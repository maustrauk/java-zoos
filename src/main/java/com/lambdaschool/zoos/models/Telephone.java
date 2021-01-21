package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    @Column(nullable = false)
    private String phonetype;

    @Column(nullable = false)
    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "zooid", nullable = false)
    @JsonIgnoreProperties(value = "telephones", allowSetters = true)
    private Zoo zoo;
}
