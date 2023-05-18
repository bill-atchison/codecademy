package com.codecademy.diningreviews.controller;

import com.codecademy.diningreviews.model.AdminReviewAction;
import com.codecademy.diningreviews.model.Restaurant;
import com.codecademy.diningreviews.model.Review;
import com.codecademy.diningreviews.model.ReviewStatus;
import com.codecademy.diningreviews.repository.RestaurantRepository;
import com.codecademy.diningreviews.repository.ReviewRepository;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public AdminController(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/reviews")
    public List<Review> getReviewsByStatus(@RequestParam String review_status) {
        ReviewStatus reviewStatus = ReviewStatus.PENDING;

        try {
            reviewStatus = ReviewStatus.valueOf(review_status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return this.reviewRepository.findReviewsByStatus(reviewStatus);
    }

    @PutMapping("/reviews/{reviewId}")
    public void performReviewAction(@PathVariable Long reviewId,
                                    @RequestBody AdminReviewAction adminReviewAction) {
        Optional<Review> optionalReview = this.reviewRepository.findById(reviewId);
        if (optionalReview.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Review currentReview = optionalReview.get();

        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(currentReview.getRestaurantId());
        if (optionalRestaurant.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (adminReviewAction.getAccept()) {
            currentReview.setStatus(ReviewStatus.ACCEPTED);
        } else {
            currentReview.setStatus(ReviewStatus.REJECTED);
        }

        this.reviewRepository.save(currentReview);
        updateRestaurantReviewScores(optionalRestaurant.get());
    }

    private void updateRestaurantReviewScores(Restaurant restaurant) {
        List<Review> reviews = this.reviewRepository.findReviewsByRestaurantIdAndStatus(restaurant.getId(), ReviewStatus.ACCEPTED);
        if (reviews.size() == 0) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        int peanutCount = 0;
        int peanutSum = 0;
        int dairyCount = 0;
        int dairySum = 0;
        int eggCount = 0;
        int eggSum = 0;

        for (Review review : reviews) {
            if (!ObjectUtils.isEmpty(review.getPeanutScore())) {
                peanutSum += review.getPeanutScore();
                peanutCount++;
            }

            if (!ObjectUtils.isEmpty(review.getDairyScore())) {
                dairySum += review.getDairyScore();
                dairyCount++;
            }

            if (!ObjectUtils.isEmpty(review.getEggScore())) {
                eggSum += review.getEggScore();
                eggCount++;
            }
        }

        int totalCount = peanutCount + dairyCount + eggCount;
        int totalSum = peanutSum + dairySum + eggSum;

        float overallScore = (float) totalSum / totalCount;
        restaurant.setOverallScore(decimalFormat.format(overallScore));

        if (peanutCount > 0) {
            float peanutScore = (float) peanutSum / peanutCount;
            restaurant.setPeanutScore(decimalFormat.format(peanutScore));
        }

        if (dairyCount > 0) {
            float dairyScore = (float) dairySum / dairyCount;
            restaurant.setDairyScore(decimalFormat.format(dairyScore));
        }

        if (eggCount > 0) {
            float eggScore = (float) eggSum / eggCount;
            restaurant.setEggScore(decimalFormat.format(eggScore));
        }

        this.restaurantRepository.save(restaurant);
    }

}
