package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.repositories.AnimalsRepository;
import com.lambdaschool.zoos.view.AnimalsCountZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "animalsService")
public class AnimalsServiceImpl implements AnimalsService {
    @Autowired
    private AnimalsRepository animalsrepos;

    @Override
    public List<AnimalsCountZoos> getAnimalsCountZoos() {
        return animalsrepos.getCountZoos();
    }
}
