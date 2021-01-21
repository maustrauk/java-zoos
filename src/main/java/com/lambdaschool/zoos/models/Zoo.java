package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  zooid;

    @Column(nullable = false, unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private List<Telephone> telephones = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "zooanimals",
    joinColumns = @JoinColumn(name = "zooid"),
    inverseJoinColumns = @JoinColumn(name = "animalid"))
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    Set<Animal> animals = new HashSet<>();


}
