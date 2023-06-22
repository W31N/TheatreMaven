package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "scene")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Scene {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "scene_id", nullable = false)
    private Short scene_id;

    @Basic
    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Basic
    @Column(name = "capacity", nullable = false)
    private Short capacity;

    @Basic
    @Column(name = "square", nullable = false)
    private Short square;

    @Basic
    @Column(name = "height", nullable = false)
    private Short height;

    @Basic
    @Column(name = "type", nullable = false, length = 16)
    private String type;

    @Basic
    @Column(name = "title", nullable = false, length = 64)
    private String title;
}
