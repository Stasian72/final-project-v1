package com.example.finalprojectv1.service;



import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.model.Owner;
import com.example.finalprojectv1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    public List<Book> getAllBooks(){

        return repository.findAll();
    }



    public Book addBook(Book book){

        return repository.save(book);
    }

    public void deleteBookById (Integer id){

       repository.deleteById(id);



    }

    public List<Book> getBooksByAuthor(String author){

        return repository.findBooksByAuthor(author);
    };

    public Book getBookById (Integer id){


        return repository.findBookById(id);
    };


    public List<Book> getBooksByOwner(String owner){

        return repository.findBooksByOwner(owner);
    }

    public List<Book> getBooksByAuthorandOwner (String author, String owner){

        return repository.findBooksByAuthorAndOwner(author, owner);
    }


}
