package com.nagarro.controller;

import com.nagarro.entity.Author;
import com.nagarro.entity.Book;
import com.nagarro.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<Author>> getAll(){
        List<Author> authors = authorService.getAll();
        if(authors.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable("id") int id){
        Author author = authorService.getAuthById(id);
        if(author == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(author);
    }
    @PostMapping()
    public ResponseEntity<Author> save(@RequestBody Author author){
        Author newAuthor = authorService.save(author);
        return ResponseEntity.ok(newAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> save(@PathVariable("id") int id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
