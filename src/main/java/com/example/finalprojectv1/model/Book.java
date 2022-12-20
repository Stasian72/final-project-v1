package com.example.finalprojectv1.model;


import lombok.*;

import javax.persistence.*;


@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String author;
    @Column(unique = true)
    private Integer iban;
    private String owner;

}
