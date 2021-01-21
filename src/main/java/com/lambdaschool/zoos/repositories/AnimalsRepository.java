package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.view.AnimalsCountZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalsRepository extends CrudRepository<Animal, Long> {

    @Query(value="SELECT DISTINCT a.animaltype AS animaltype, " +
            "a.animalid AS animalid, " +
            "COUNT(zooid) AS countzoos " +
            "FROM animals a " +
            "LEFT  JOIN zooanimals z " +
            "ON a.animalid = z.animalid " +
            "GROUP BY animaltype",
    nativeQuery = true)
    List<AnimalsCountZoos> getCountZoos();
}
