package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZoosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZoosController {
    @Autowired
    private ZoosService zoosService;

    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> getAllZoos() {

        List<Zoo> myZoos = zoosService.findAllZoos();

        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }

    @GetMapping(value = "/zoo/{id}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable long id) {
        Zoo z = zoosService.findZooById(id);

        return new ResponseEntity<>(z, HttpStatus.OK);
    }
}
