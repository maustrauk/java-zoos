package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalsRepository extends CrudRepository<Animal, Long> {
}
