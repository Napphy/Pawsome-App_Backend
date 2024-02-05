package com.rijai.users.repositry;

import com.rijai.users.model.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Integer> {
}
