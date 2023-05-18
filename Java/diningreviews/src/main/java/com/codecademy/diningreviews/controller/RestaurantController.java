package com.codecademy.diningreviews.controller;

import com.codecademy.diningreviews.model.Restaurant;
import com.codecademy.diningreviews.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    private final Pattern zipCodePattern = Pattern.compile("\\d{5}");

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        validateNewRestaurant(restaurant);

        this.restaurantRepository.save(restaurant);
    }

    @GetMapping
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(id);
        if (optionalRestaurant.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return optionalRestaurant.get();
    }

    @GetMapping("/search")
    public List<Restaurant> searchRestaurants(@RequestParam String zipCode,
                                              @RequestParam String allergy) {
        validateZipCode(zipCode);

        List<Restaurant> restaurants = Collections.EMPTY_LIST;
        if (allergy.equalsIgnoreCase("peanut")) {
            restaurants = this.restaurantRepository.findRestaurantsByZipCodeAndPeanutScoreNotNullOrderByPeanutScore(zipCode);
        } else if (allergy.equalsIgnoreCase("dairy")) {
            restaurants = this.restaurantRepository.findRestaurantsByZipCodeAndDairyScoreNotNullOrderByDairyScore(zipCode);
        } else if (allergy.equalsIgnoreCase("egg")) {
            restaurants = this.restaurantRepository.findRestaurantsByZipCodeAndEggScoreNotNullOrderByEggScore(zipCode);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return restaurants;
    }

    private void validateNewRestaurant(Restaurant restaurant) {
        if (ObjectUtils.isEmpty(restaurant.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        validateZipCode(restaurant.getZipCode());

        Optional<Restaurant> optionalRestaurant =
                this.restaurantRepository.findRestaurantsByNameAndZipCode(restaurant.getName(), restaurant.getZipCode());
        if (optionalRestaurant.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    private void validateZipCode(String zipCode) {
        if (!zipCodePattern.matcher(zipCode).matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
