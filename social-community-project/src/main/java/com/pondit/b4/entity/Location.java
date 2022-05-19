package com.pondit.b4.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "location_name")
    private String locationName;
}