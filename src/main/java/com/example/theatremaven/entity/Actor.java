package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "actor")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Actor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "personnel_number", nullable = false)
    private Short personnel_number;

    @Basic
    @Column(name = "passport_data", nullable = false)
    private Long passport_data;


    @Basic
    @Column(name = "height", nullable = false)
    private Short height;

    @Basic
    @Column(name = "weight", nullable = false)
    private Short weight;

    @Basic
    @Column(name = "career_start_year", nullable = false)
    private Short career_start_year;
}
