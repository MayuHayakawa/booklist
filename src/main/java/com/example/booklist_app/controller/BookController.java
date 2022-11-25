package com.example.booklist_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.booklist_app.entity.Book;
import com.example.booklist_app.form.BookForm;
import com.example.booklist_app.form.EditBookForm;
import com.example.booklist_app.service.BookService;


// Controls the processing of requests
@Controller
public class BookController {
    
    @Autowired
    BookService bookservice;

    //display all books information
    @GetMapping("/book-list")
    public String bookList(Model model) {
        // get books infomation useing service
        List<Book> bookList = bookservice.findAll();
        // Set up booklist in the model and pass it to the display
        model.addAttribute("bookList", bookList);
        //display bookList.html
        return "book-list";
    }

    // -----ADD-----
    @GetMapping("/book-create")
    public String createBook(Model model) {
        model.addAttribute("bookForm", new BookForm());
        return "add";
    }

    @PostMapping("/book-create")
    public String saveBook(@ModelAttribute @Validated BookForm bookForm, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add";
        }
        bookservice.insert(bookForm);
        return "redirect:/book-list";
    }

    // -----EDIT-----
    // show the edit page when a link is pressed
    @GetMapping("/book-edit")
    public String editBook(Model model, EditBookForm editBookForm) {
        // get id from requests data
        editBookForm = bookservice.getOneBook(editBookForm.getId());
        // set up data get on the model
        model.addAttribute(editBookForm);
        return "edit";
    }

    // Receives the value edited on the edit page and performs the update process
    @PostMapping("/book-edit")
    public String update(@ModelAttribute @Validated EditBookForm editBookForm, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "edit";
        }
        bookservice.update(editBookForm);
        return "redirect:/book-list";
    }

    // -----DELETE-----
    @GetMapping("/book-delete")
    public String deleteBook(Model model, Book book) {
        bookservice.delete(book.getId());
        return "redirect:/book-list";
    }
}