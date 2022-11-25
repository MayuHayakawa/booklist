package com.example.booklist_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booklist_app.entity.Book;

// To interface JpaRepository allow using some methods access to databade
public interface BookRepository extends JpaRepository<Book, Integer>  {
    
}
