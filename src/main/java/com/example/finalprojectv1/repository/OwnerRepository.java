package com.example.finalprojectv1.repository;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {



    Owner findByEmail (String email);
}
