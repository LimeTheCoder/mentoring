package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name = "user_profile_info")
@Getter
@Setter
public abstract class UserProfile {
    @Id
    @Column(name = "user_identificator")
    private String id;

    private String name;
    private String surname;
    @Column(name = "second_name")
    private String secondName;

    private int age;
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
}
