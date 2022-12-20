package com.example.finalprojectv1.controller;
import org.springframework.ui.Model;
import com.example.finalprojectv1.config.SecurityConfig;
import com.example.finalprojectv1.repository.OwnerRepository;
import com.example.finalprojectv1.security.AuthProviderImpl;
import com.example.finalprojectv1.service.BookService;
import com.example.finalprojectv1.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@WebMvcTest(controllers = BookControllerV2.class)
class BookControllerV2Test {

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
    private AuthProviderImpl authProvider;

    @Test
    void getBooks()throws Exception {



//        BDDMockito.given(bookService.getBooksByAuthor(null)).willReturn(List.of());
//
//
//        mockMvc.perform(get("/api/v2/books"))
//
//                .andExpect(status().isOk());
//
//        BDDMockito.given(bookService.getBooksByAuthor("Толстой")).willReturn(List.of());
//
//        mockMvc.perform(get("/api/v2/books"))
//
//                .andExpect(status().isOk());
    }


    @Test
    void testGetBooks() {
    }

    @Test
    void signUp() {
    }

    @Test
    void getSignUp2() {
    }

    @Test
    void putBook() {
    }
}