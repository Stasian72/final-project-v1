package com.example.finalprojectv1.controller;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/v2")
public class BookControllerV2 {

    @Autowired
    private BookService service;
//
//    @GetMapping("/books")
//    public String getBooks(HttpServletRequest request, Model model) {
//
//
//        String author = request.getParameter("author");
////|| author == null
//
//        if (author.equals("")|| author == null) {
//
//            return "redirect:/api/v2/books/all";
//
//
//
//        } else {
//            List<Book> booksByAuthor = service.getBooksByAuthor(author);
//            model.addAttribute("booksAttr", booksByAuthor);
//            return "/books";
//
//        }
//    }

    @GetMapping("/books")
    public String getBooks(@RequestParam(value = "author", required = false)String author, Model model) {




        if (author.equals("")||author.equals(null)) {

            return "redirect:/api/v2/books/all";



        } else {
            List<Book> booksByAuthor = service.getBooksByAuthor(author);
            model.addAttribute("booksAttr", booksByAuthor);
            return "/books";

        }
    }






    @GetMapping("/books/all")
    public String getBooks(Model model) {

        List<Book> allBooks = service.getAllBooks();
        model.addAttribute("booksAttr", allBooks);
        return "/books";

    }
    @PostMapping("/books/new")
    public String signUp(@ModelAttribute Book book) {

        service.addBook(book);
        return "redirect:/api/v2/books/all";

    }


    @GetMapping()
    public String getSignUp2() {
        return "/choice";

    }
//
    @PutMapping ("/books/put")
    public  String putBook (@ModelAttribute Book book) {

        service.addBook(book);
        return "redirect:/api/v2/books/all";
    }

}