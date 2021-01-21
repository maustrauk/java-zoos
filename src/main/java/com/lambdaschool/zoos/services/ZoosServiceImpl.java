package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.ZoosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zoosService")
public class ZoosServiceImpl implements ZoosService{
    @Autowired
    private ZoosRepository zoosrepos;

    @Override
    public List<Zoo> findAllZoos() {
        List<Zoo> list = new ArrayList<>();

        zoosrepos.findAll().iterator().forEachRemaining(list::add);

        return list;
    }
}
