package com.example.finalprojectv1.repository;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    void findByEmail() {

        Owner owner1 = Owner.builder()
                .id(null)
                .ownerName("А1")
                .email("11@11")
                .password("11")
                .build();

        Owner owner2 = Owner.builder()
                .id(null)
                .ownerName("А2")
                .email("22@22")
                .password("22")
                .build();

        entityManager.persist(owner1);
        entityManager.persist(owner2);

        Owner owner = ownerRepository.findByEmail("11@11");

        assertThat(owner.getOwnerName()).isEqualTo("А1");
        assertThat(owner.getPassword()).isEqualTo("11");
        assertThat(owner.getClass()).isEqualTo(Owner.class);

    }
}