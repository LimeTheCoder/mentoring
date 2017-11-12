package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;


@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name = "user_profile_info")
@Getter
@Setter
public abstract class UserProfile {
    @Id
    @Column(name = "user_identificator")
    @NotBlank
    private String key;

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Column(name = "second_name")
    private String secondName;

    private int age;
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "address_id")
    private Address address;
}
