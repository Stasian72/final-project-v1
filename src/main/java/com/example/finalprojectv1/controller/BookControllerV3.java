package com.example.finalprojectv1.controller;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.model.Owner;
import com.example.finalprojectv1.security.AuthProviderImpl;
import com.example.finalprojectv1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/v3")
public class BookControllerV3 {

    @Autowired  // внедряем ранее созданный бин userService
    private BookService service;

    @Autowired      // внедряем бин authProvider
    private AuthProviderImpl authProvider;




    @GetMapping("/books")
    public String getBooks(HttpServletRequest request, Model model) {

        String owner = authProvider.getOwner().getOwnerName();
        String author = request.getParameter("author");

        if (!author.equals("")&&!author.equals(null) ) {
            List<Book> booksByAuthorandOwner = service.getBooksByAuthorandOwner(author, owner);
            model.addAttribute("booksAttr", booksByAuthorandOwner);
            return "/books";
        }
        else {
            List<Book> booksByOwner = service.getBooksByOwner(owner);
//            List<Book> booksByAuthor = service.getBooksByAuthor(author);
            model.addAttribute("booksAttr", booksByOwner);
            return "/books";
        }

//
    }



    @PostMapping("/books/new")
    public String signUp(@ModelAttribute Book book) {    // блягодаря @ModelAttribute мы создаем нового USER
        // с параметрами, которые указали в sign_up.ftl
        String owner = authProvider.getOwner().getOwnerName();
        book.setOwner(owner);
        service.addBook(book);                          // добавляем в БД через service
        return "redirect:/api/v3/books?author=";           // повторно вызываем метод GET getUsers() по endpoint ("/users")
        // и возвращает новый список
    }



    @GetMapping()
    public String getSignUp2() {
        return "/choiceOwner";

    }

    //
    @PutMapping("/books/put")
    public String putBook(@ModelAttribute Book book) {

        service.addBook(book);
        return "redirect:/api/v3/books/all";
    }
}
