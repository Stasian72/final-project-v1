package com.example.finalprojectv1.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "owners")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ownerName;
    private String email;
    private String password;
}

