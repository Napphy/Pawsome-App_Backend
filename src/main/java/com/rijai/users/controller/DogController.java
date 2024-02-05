package com.rijai.users.controller;

import com.rijai.users.model.Dog;
import com.rijai.users.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/")
    public List<Dog> getAllDog() {
        return dogService.getAllDogs();
    }

    @GetMapping(value="/dogs/{id}")
    public Dog getDog(@PathVariable int id) {
        return dogService.getDog(id);
    }

    @PostMapping(value="/add-dog")
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @PutMapping(value="/update-dog")
    public Dog updateDog(@RequestBody Dog dog) {
        return dogService.updateDog(dog);
    }
    @DeleteMapping(value="/dogs/{id}")
    public void deleteUser(@PathVariable int id) {
        dogService.deleteDog(id);
    }
}
