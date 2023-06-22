package com.example.theatremaven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "piece")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Piece {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "piece_id", nullable = false)
    private Short piece_id;

    @Basic
    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Basic
    @Column(name = "author", nullable = false, length = 64)
    private String author;

    @Basic
    @Column(name = "genre", nullable = false, length = 32)
    private String genre;

    @Basic
    @Column(name = "publication_date", nullable = false)
    private Date publication_date;
}
