package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZoosRepository extends CrudRepository<Zoo, Long> {
}
