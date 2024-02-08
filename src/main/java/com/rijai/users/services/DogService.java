package com.rijai.users.services;

import com.rijai.users.model.Dog;
import com.rijai.users.repositry.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public List<Dog> getAllDogs()
    {
        List <Dog> dogRecords = new ArrayList<>();
        Streamable.of(dogRepository.findAll())
                .forEach(dogRecords::add);
        return dogRecords;
    }

    public Dog addDog(Dog dog){
        return dogRepository.save(dog);
    }

    public Dog updateDog(int id, Dog updatedDog) {
        Dog existingDog = dogRepository.findById(id).orElse(null);
        if (existingDog != null) {
            // Update the existing dog with the values from the updatedDog object
            existingDog.setName(updatedDog.getName());
            existingDog.setAge(updatedDog.getAge());
            existingDog.setBreed(updatedDog.getBreed());
            existingDog.setSex(updatedDog.getSex());
            existingDog.setSize(updatedDog.getSize());
            existingDog.setBirthday(updatedDog.getBirthday());
            existingDog.setDescription(updatedDog.getDescription());
            existingDog.setImage(updatedDog.getImage());
            // Save the updated dog
            return dogRepository.save(existingDog);
        } else {
            // Handle the case where the dog with the given ID is not found
            throw new IllegalArgumentException("Dog not found with id: " + id);
        }
    }

    public Dog getDog(int id){
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent()){
            return dog.get();
        }else
            return null;
    }

    public void deleteDog(int id){
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isPresent()){
            dogRepository.delete(dog.get());
        }
    }
}
