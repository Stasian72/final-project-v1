package com.example.finalprojectv1.controller;


import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.service.BookService;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService service;


//@GetMapping("/books")
//@ResponseBody
//    public List<Book> getAllBooks(){
//
//    return service.getAllBooks();
//}
@GetMapping("/books")
@ResponseBody
public  List<Book> getBooks(HttpServletRequest request){

    String author = request.getParameter("author");
    if (author==null){
        return service.getAllBooks();
    }
else {
        return service.getBooksByAuthor(author);
    }


}
@GetMapping("/books/{id}")
public  Book getBookById (@PathVariable("id") Integer id){

    return  service.getBookById(id);
}
@PutMapping ("/books/{id}")
    public  Book putBook (@PathVariable("id") Integer id, @RequestBody Book book) {
    book.setId(id);

    return service.addBook(book);
}
@DeleteMapping("/books/delete/{id}")
    public   void   deleteBookById (@PathVariable("id") Integer id){

   service.deleteBookById(id);


//    return "redirect:/api/v1/books/";


}




@PostMapping("/books")
@ResponseStatus
public Book addBook(@RequestBody Book book){

    return service.addBook(book);

}




}
