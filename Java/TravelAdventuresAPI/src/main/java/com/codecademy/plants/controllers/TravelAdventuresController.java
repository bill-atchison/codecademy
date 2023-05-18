package com.codecademy.plants.controllers;

import com.codecademy.plants.entities.Adventure;
import com.codecademy.plants.repositories.AdventureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/traveladventures")
public class TravelAdventuresController {

    private final AdventureRepository adventureRepository;

    public TravelAdventuresController(AdventureRepository adventureRepo) {
        this.adventureRepository = adventureRepo;
    }

    // Add controller methods below:
    @GetMapping()
    public Iterable<Adventure> findAll() {
        return this.adventureRepository.findAll();
     }

     @GetMapping("/bycountry/{country}")
     public List<Adventure> findByCountry(@PathVariable String country) {
        return this.adventureRepository.findByCountry(country);
     }

    @GetMapping("/bystate")
     public List<Adventure> findByState(@RequestParam String state) {
         return this.adventureRepository.findByState(state);
    }

    @PostMapping()
    public Adventure save(@RequestBody Adventure adventure) {
        return this.adventureRepository.save(adventure);
    }

    @PutMapping("/{id}")
    public Adventure update(@PathVariable int id, @RequestBody Adventure adventure) {
        Optional<Adventure> currentAdventure = this.adventureRepository.findById(id);

        if (currentAdventure.isPresent()) {
            adventure.setBlogCompleted(!adventure.getBlogCompleted());
            return this.adventureRepository.save(adventure);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try {
            this.adventureRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}