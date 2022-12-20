package com.example.finalprojectv1.service;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.model.Owner;
import com.example.finalprojectv1.repository.BookRepository;
import com.example.finalprojectv1.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @InjectMocks
    private OwnerService ownerService;

    @Mock
    private OwnerRepository ownerRepository;

    @Test
    void addOwner() {

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

        given(ownerRepository.save(owner1)).willReturn(owner1);

        Owner owner = ownerService.addOwner(owner1);
        assertThat(owner.getOwnerName()).isEqualTo("А1");
        assertThat(owner.getEmail()).isEqualTo("11@11");
        assertThat(owner.getPassword()).isEqualTo("11");
        assertThat(owner.getClass()).isEqualTo(Owner.class);
        assertThat(owner.getId()).isEqualTo(null);

    }
}