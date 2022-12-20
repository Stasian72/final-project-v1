package com.example.finalprojectv1.repository;



import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Integer> {


    List<Book> findBooksByAuthor(String author);
    Book findBookById (Integer id);
    List<Book> findBooksByOwner(String owner);

    List<Book> findBooksByAuthorAndOwner (String author, String owner);

//    void deleteBookById(Integer id);


    




}
