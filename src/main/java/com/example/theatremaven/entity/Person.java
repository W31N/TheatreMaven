package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "person")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "passport_data", nullable = false)
    private Long passport_data;

    @Basic
    @Column(name = "gender", nullable = false, length = 16)
    private String gender;

    @Basic
    @Column(name = "full_name", nullable = false, length = 128)
    private String full_name;

    @Basic
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

}
