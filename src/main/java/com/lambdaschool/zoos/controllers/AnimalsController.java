package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.services.AnimalsService;
import com.lambdaschool.zoos.view.AnimalsCountZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsController {
    @Autowired
    private AnimalsService animalsService;

    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> getCountAnimals() {
        List<AnimalsCountZoos> myList = animalsService.getAnimalsCountZoos();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
