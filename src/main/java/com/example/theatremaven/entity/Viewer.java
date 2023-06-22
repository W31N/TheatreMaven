package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "viewer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Viewer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "viewer_id", nullable = false)
    private Short viewer_id;

    @Basic
    @Column(name = "passport_data", nullable = false)
    private Long passport_data;

    @Basic
    @Column(name = "preference", nullable = false, length = 32)
    private String preference;
}
