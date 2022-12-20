package com.example.finalprojectv1.service;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

     @Mock
    private BookRepository bookRepository;



    @Test
    void getAllBooks() {

        Book book1 = Book.builder()
                .id(1)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(2)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В2")
                .build();

        given(bookRepository.findAll()).willReturn(List.of(book1, book2));
        List<Book> books = bookService.getAllBooks();
        assertThat(books).hasSize(2);
        assertThat(books.get(1).getId()).isEqualTo(2);
    }

    @Test
    void addBook() {

        Book book1 = Book.builder()
                .id(1)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(2)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В2")
                .build();

        given(bookRepository.save(book1)).willReturn(book1);
        Book bookNew = bookService.addBook(book1);
        assertThat(bookNew.getName()).isEqualTo("Б1");
        assertThat(bookNew.getOwner()).isEqualTo("В1");
        assertThat(bookNew.getIban()).isEqualTo(11);
        assertThat(bookNew.getId()).isEqualTo(1);


    }

    @Test
    void findBooksByAuthor() {
        Book book1 = Book.builder()
                .id(1)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(2)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В2")
                .build();

        given(bookRepository.findBooksByAuthor("А1")).willReturn(List.of(book1));
        given(bookRepository.findBooksByAuthor("А2")).willReturn(List.of(book2));
        List<Book> books = bookService.getBooksByAuthor("А1");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getId()).isEqualTo(1);
        assertThat(books.get(0).getName()).isEqualTo("Б1");
        assertThat(books.get(0).getIban()).isEqualTo(11);
        List<Book> books2 = bookService.getBooksByAuthor("А2");
        assertThat(books2).hasSize(1);
        assertThat(books2.get(0).getId()).isEqualTo(2);
        assertThat(books2.get(0).getName()).isEqualTo("Б2");
        assertThat(books2.get(0).getIban()).isEqualTo(22);


    }

    @Test
    void findBookById() {

        Book book1 = Book.builder()
                .id(1)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(2)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В2")
                .build();

        given(bookRepository.findBookById(2)).willReturn(book2);
        given(bookRepository.findBookById(1)).willReturn(book1);
        Book book = bookService.getBookById(2);
        assertThat(book.getId()).isEqualTo(2);
        assertThat(book.getName()).isEqualTo("Б2");
        assertThat(book.getIban()).isEqualTo(22);
        assertThat(book.getAuthor()).isEqualTo("А2");
        assertThat(book.getOwner()).isEqualTo("В2");

        Book book22 = bookService.getBookById(1);
        assertThat(book22.getId()).isEqualTo(1);
        assertThat(book22.getName()).isEqualTo("Б1");
        assertThat(book22.getIban()).isEqualTo(11);
        assertThat(book22.getAuthor()).isEqualTo("А1");
        assertThat(book22.getOwner()).isEqualTo("В1");

    }
    @Test
    void  getBooksByOwner(){

        Book book1 = Book.builder()
                .id(1)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(2)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В1")
                .build();
        given(bookRepository.findBooksByOwner("В1")).willReturn(List.of(book1, book2));
        List<Book> books = bookService.getBooksByOwner("В1");
        assertThat(books).hasSize(2);
        assertThat(books).contains(book1);
        assertThat(books).contains(book2);
        assertThat(books.get(0).getName()).isEqualTo("Б1");

    }
    @Test
    void getBooksByAuthorandOwner(){
        Book book1 = Book.builder()
                .id(1)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(2)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В2")
                .build();

        given(bookRepository.findBooksByAuthorAndOwner("А1", "B1")).willReturn(List.of(book1));
        List<Book> books = bookService.getBooksByAuthorandOwner("А1", "B1");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getId()).isEqualTo(1);
        assertThat(books.get(0).getName()).isEqualTo("Б1");
        assertThat(books.get(0).getIban()).isEqualTo(11);


    }

}