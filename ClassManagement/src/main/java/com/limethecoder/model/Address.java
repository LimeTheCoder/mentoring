package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    private int id;

    @Column(name = "postal_code")
    private String postalCode;
    private String country;
    private String city;
    private String street;
    private String building;
}
