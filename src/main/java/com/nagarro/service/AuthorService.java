package com.nagarro.service;

import com.nagarro.entity.Author;
import com.nagarro.entity.Book;
import com.nagarro.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author getAuthById(int id){
        return  authorRepository.findById(id).orElse(null);
    }

    public Author save(Author author){
        Author authorNew = authorRepository.save(author);
        return authorNew;
    }

    public void delete(int id){
        authorRepository.deleteById(id);
    }
}
