package com.codecademy.diningreviews.controller;

import com.codecademy.diningreviews.model.User;
import com.codecademy.diningreviews.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        validateUser(user);
        this.userRepository.save(user);
    }

    @GetMapping("/{displayName}")
    public User getUser(@PathVariable String displayName) {
        validateDisplayName(displayName);

        Optional<User> optionalUser = this.userRepository.findUsersByDisplayName(displayName);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        User existingUser = optionalUser.get();
        existingUser.setId(null);

        return existingUser;
    }

    @PutMapping("/{displayName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserInfo(@PathVariable String displayName, @RequestBody User updatedUser) {
        validateDisplayName(displayName);

        Optional<User> optionalUser = this.userRepository.findUsersByDisplayName(displayName);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        User existingUser = optionalUser.get();
        copyUserInfoFrom(updatedUser, existingUser);
        this.userRepository.save(existingUser);
    }

    private void copyUserInfoFrom(User updatedUser, User existingUser) {
        if (ObjectUtils.isEmpty(updatedUser.getDisplayName())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (!ObjectUtils.isEmpty(updatedUser.getCity())) {
            existingUser.setCity(updatedUser.getCity());
        }

        if (!ObjectUtils.isEmpty(updatedUser.getState())) {
            existingUser.setState(updatedUser.getState());
        }

        if (!ObjectUtils.isEmpty(updatedUser.getZipCode())) {
            existingUser.setZipCode(updatedUser.getZipCode());
        }

        if (!ObjectUtils.isEmpty(updatedUser.getDairyWatch())) {
            existingUser.setDairyWatch(updatedUser.getDairyWatch());
        }

        if (!ObjectUtils.isEmpty(updatedUser.getPeanutWatch())) {
            existingUser.setPeanutWatch(updatedUser.getPeanutWatch());
        }

        if (!ObjectUtils.isEmpty(updatedUser.getEggWatch())) {
            existingUser.setEggWatch(updatedUser.getEggWatch());
        }
    }

    private void validateUser(User user) {
        validateDisplayName(user.getDisplayName());

        Optional<User> existingUser = this.userRepository.findUsersByDisplayName(user.getDisplayName());
        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    private void validateDisplayName(String displayName) {
        if (ObjectUtils.isEmpty(displayName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
