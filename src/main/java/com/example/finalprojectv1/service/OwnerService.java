package com.example.finalprojectv1.service;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.model.Owner;
import com.example.finalprojectv1.repository.BookRepository;
import com.example.finalprojectv1.repository.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    private final OwnerRepository repository;

    public OwnerService (OwnerRepository repository) {
        this.repository = repository;
    }

    public Owner addOwner (Owner owner){


        return repository.save(owner);
    }
}
