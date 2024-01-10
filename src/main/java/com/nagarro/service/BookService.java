package com.nagarro.service;

import com.nagarro.entity.Author;
import com.nagarro.entity.Book;
import com.nagarro.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;


    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getBookById(String id){
        return  bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book){
        Author author = authorRepository.findById(book.getAuthor().getId()).orElse(null);
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    public void delete(String id){
        bookRepository.deleteById(id);
    }
}
