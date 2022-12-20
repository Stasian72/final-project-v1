package com.example.finalprojectv1.controller;

import com.example.finalprojectv1.config.SecurityConfig;
import com.example.finalprojectv1.config.SecurityInitializer;
import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.repository.OwnerRepository;
import com.example.finalprojectv1.security.AuthProviderImpl;
import com.example.finalprojectv1.service.BookService;
import com.example.finalprojectv1.service.OwnerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Around;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class)
class BookControllerTest {
    @MockBean
    private BookService bookService;
    @MockBean
    private OwnerService ownerService;
    @MockBean
    private OwnerRepository ownerRepository;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private  AuthProviderImpl authProvider;


    @Test
    void getBooks()throws Exception {



        BDDMockito.given(bookService.getAllBooks()).willReturn(List.of());


        mockMvc.perform(get("/api/v1/books"))

                .andExpect(status().isOk());

        BDDMockito.given(bookService.getBooksByAuthor("Толстой")).willReturn(List.of());

        mockMvc.perform(get("/api/v1/books?author=Толстой"))

                .andExpect(status().isOk());
    }



    @Test
    void getBookById() throws Exception {
        BDDMockito.given(bookService.getBookById(1)).willReturn(new Book());

        mockMvc.perform(get("/api/v1/books/1"))

                .andExpect(status().isOk());
    }


    @Test
    void putBook() throws Exception {
    }

    @Test
    void saveBook() throws Exception {

//        Book book1 = Book.builder()
//                .id(null)
//                .author("А1")
//                .name("Б1")
//                .iban(11)
//                .owner("В1")
//                .build();
//
//
//
//        BDDMockito.given(bookService.addBook(book1)).willReturn(new Book());
//
//        ObjectMapper objectMapper = null;
//        mockMvc.perform(post ("/api/v1/books", book1)
//        .content(objectMapper.writeValueAsString(book1))
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk());


    }
}



