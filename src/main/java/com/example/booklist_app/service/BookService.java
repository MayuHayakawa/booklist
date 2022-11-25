package com.example.booklist_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.booklist_app.entity.Book;
import com.example.booklist_app.form.BookForm;
import com.example.booklist_app.form.EditBookForm;
import com.example.booklist_app.repository.BookRepository;

// Converts input values by user on the screen into a class for database registration 
// and calls a method to register them in the database
@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // get books infomation
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void insert(BookForm bookForm) {
        // Instances that hold values to be registered in the database
        Book book = new Book();

        // Pass values received from the screen to instances to be stored in the database
        book.setTitle(bookForm.getTitle());
        book.setPrice(bookForm.getPrice());

        // register in the database
        bookRepository.save(book);
    }

    // get data from the received id and return EditBookForm
    public EditBookForm getOneBook(Integer id) {
        // get information about a book by specifying its id
        Book book = bookRepository.findById(id).orElseThrow();
        // Set the value of the Form for the edit page
        EditBookForm editBookForm = new EditBookForm();
        editBookForm.setId(book.getId());
        editBookForm.setTitle(book.getTitle());
        editBookForm.setPrice(book.getPrice());

        return editBookForm;
    }

    public void update(EditBookForm editBookForm) {
        
        // Creating an instance to hold the values to be registered in the database
        Book book = new Book();
        // Set the value received from the input on the display
        book.setId(editBookForm.getId());
        book.setTitle(editBookForm.getTitle());
        book.setPrice(editBookForm.getPrice());
        // update database
        bookRepository.save(book);   
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}