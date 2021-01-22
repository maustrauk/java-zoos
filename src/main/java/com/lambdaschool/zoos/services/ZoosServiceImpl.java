package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.models.ZooAnimal;
import com.lambdaschool.zoos.repositories.AnimalsRepository;
import com.lambdaschool.zoos.repositories.TelephonesRepository;
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

    @Autowired
    private TelephonesRepository phonesrepos;

    @Autowired
    private AnimalsRepository animalsrepos;

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

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();

        if(zoo.getZooid() != 0) {
            zoosrepos.findById(zoo.getZooid())
                    .orElseThrow(() -> new EntityNotFoundException("Zoo " + zoo.getZooid() + " not found!"));
            newZoo.setZooid(zoo.getZooid());
        }

        newZoo.setZooname(zoo.getZooname());

        newZoo.getTelephones().clear();
        for (Telephone t: zoo.getTelephones()) {
            Telephone newTelephone = new Telephone();

            if(t.getPhoneid() != 0) {
                phonesrepos.findById(t.getPhoneid())
                        .orElseThrow(() -> new EntityNotFoundException("Telephone " + t.getPhoneid() + " not found!"));
                newTelephone.setPhoneid(t.getPhoneid());
            }

            newTelephone.setPhonetype(t.getPhonetype());
            newTelephone.setPhonenumber(t.getPhonenumber());
            newTelephone.setZoo(newZoo);

            newZoo.getTelephones().add(newTelephone);
        }

        newZoo.getAnimals().clear();
        for (ZooAnimal za: zoo.getAnimals()) {
            ZooAnimal newZooAnimal = new ZooAnimal();

            newZooAnimal.setZoo(newZoo);


            if(za.getAnimal().getAnimalid() != 0) {
                newZooAnimal.setAnimal(
                        animalsrepos.findById(za.getAnimal().getAnimalid())
                                .orElseThrow(() -> new EntityNotFoundException("Animal " + za.getAnimal().getAnimalid() +" not found!"))
                );
            }

            newZooAnimal.setIncomingzoo(za.getIncomingzoo());

            newZoo.getAnimals().add(newZooAnimal);
        }


        return zoosrepos.save(newZoo);
    }

}
