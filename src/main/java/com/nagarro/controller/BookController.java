package com.nagarro.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.nagarro.entity.Author;
import com.nagarro.entity.Book;
import com.nagarro.service.BookService;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> getAll(){
        List<Book> books = bookService.getAll();
        if(books.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") String id){
        Book book = bookService.getBookById(id);
        if(book == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(book);
    }
    @PostMapping()
    @ResponseBody
    public ResponseEntity<Book> save(@RequestBody Book book){

        Book newBook = bookService.save(book);
        return ResponseEntity.ok(newBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> save(@PathVariable("id") String id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
