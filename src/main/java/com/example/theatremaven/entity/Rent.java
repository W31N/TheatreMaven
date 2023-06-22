package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "rent")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rent {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "scene_theatre_id", nullable = false)
    private Short scene_theatre_id;

    @Basic
    @Column(name = "scene_id", nullable = false)
    private Short scene_id;

    @Basic
    @Column(name = "theatre_id", nullable = false)
    private Short theatre_id;
}
