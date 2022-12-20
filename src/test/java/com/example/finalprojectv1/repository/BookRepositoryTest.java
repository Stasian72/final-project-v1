package com.example.finalprojectv1.repository;

import com.example.finalprojectv1.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
@Autowired
    private EntityManager entityManager;
    @Test
    void testfindBooksByAuthor() {
        Book book1 = Book.builder()
                .id(null)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(null)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В2")
                .build();
        entityManager.persist(book1);
        entityManager.persist(book2);

//        bookRepository.save(book1);
//        bookRepository.save(book2);

        List<Book> books = bookRepository.findBooksByAuthor("А1");
        assertThat(books).hasSize(1);
       assertThat(books.get(0).getName()).isEqualTo("Б1");
        assertThat(books.contains(book1));
//        assertThat(books.get(0).getId()).isEqualTo(5);
    }

    @Test
    void findBookById() {
        Book book1 = Book.builder()
                .id(null)
                .author("А1")
                .name("Б1")
                .iban(11)
                .owner("В1")
                .build();

        Book book2 = Book.builder()
                .id(null)
                .author("А2")
                .name("Б2")
                .iban(22)
                .owner("В2")
                .build();
        entityManager.persist(book1);
        entityManager.persist(book2);

//        bookRepository.save(book1);
//        bookRepository.save(book2);

        Book book = bookRepository.findBookById(1);
//        assertThat(book).isEqualTo(Book.class);
        assertThat(book.getAuthor()).isEqualTo("А1");
         assertThat(book.getName()).isEqualTo("Б1");
        assertThat(book.getClass()).isEqualTo(Book.class);

    }
@Test
    void findBooksByOwner(){

    Book book1 = Book.builder()
            .id(null)
            .author("А1")
            .name("Б1")
            .iban(11)
            .owner("В1")
            .build();

    Book book2 = Book.builder()
            .id(null)
            .author("А2")
            .name("Б2")
            .iban(22)
            .owner("В1")
            .build();
    entityManager.persist(book1);
    entityManager.persist(book2);

    List<Book> books = bookRepository.findBooksByOwner("В1");

    assertThat(books).hasSize(2);
    assertThat(books.get(0).getName()).isEqualTo("Б1");
    assertThat(books).contains(book1, book2);
    assertThat(books.get(1).getName()).isEqualTo("Б2");

}
@Test
   void  findBooksByAuthorAndOwner(){

    Book book1 = Book.builder()
            .id(null)
            .author("А1")
            .name("Б1")
            .iban(11)
            .owner("В1")
            .build();

    Book book2 = Book.builder()
            .id(null)
            .author("А2")
            .name("Б2")
            .iban(22)
            .owner("В1")
            .build();

    entityManager.persist(book1);
    entityManager.persist(book2);

    List<Book> books = bookRepository.findBooksByAuthorAndOwner("А2", "В1");

    assertThat(books).hasSize(1);
    assertThat(books.get(0).getName()).isEqualTo("Б2");
    assertThat(books).contains( book2);
    assertThat(books.get(0).getAuthor()).isEqualTo("А2");
    assertThat(books.get(0).getClass()).isEqualTo(Book.class);


}
}