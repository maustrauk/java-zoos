package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    @Column(nullable = false)
    private String animaltype;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Set<Zoo> zoos = new HashSet<>();
}
