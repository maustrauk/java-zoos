package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.ZoosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Zoo findZooById(long id)
    throws EntityNotFoundException {
        return zoosrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id +" Not found!"));
    }

    @Transactional
    @Override
    public void delete(long id) {
        if(zoosrepos.findById(id).isPresent()) {
            zoosrepos.deleteById(id);
        } else {
            throw new EntityNotFoundException("Zoo " + id + " not found!");
        }
    }
}
