package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "performance")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Performance {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "performance_id", nullable = false)
    private Short performance_id;

    @Basic
    @Column(name = "scene_id", nullable = false)
    private Short scene_id;

    @Basic
    @Column(name = "piece_id", nullable = false)
    private Short piece_id;

    @Basic
    @Column(name = "genre", nullable = false, length = 32)
    private String genre;

    @Basic
    @Column(name = "director", nullable = false, length = 64)
    private String director;

    @Basic
    @Column(name = "start_date", nullable = false)
    private Date start_date;

    @Basic
    @Column(name = "start_time", nullable = false)
    private Time start_time;

    @Basic
    @Column(name = "end_time", nullable = false)
    private Time end_time;

    @Basic
    @Column(name = "title", nullable = false, length = 64)
    private String title;
}
