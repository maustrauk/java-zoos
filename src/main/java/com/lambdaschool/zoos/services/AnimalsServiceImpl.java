package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.repositories.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "animalsService")
public class AnimalsServiceImpl implements AnimalsService {
    @Autowired
    private AnimalsRepository animalsrepos;
}
