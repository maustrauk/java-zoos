package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephonesRepository extends CrudRepository<Telephone, Long> {
}
