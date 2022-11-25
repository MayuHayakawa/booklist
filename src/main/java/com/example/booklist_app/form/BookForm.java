package com.example.booklist_app.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

// For retain values entered by the user on screen
@Data
public class BookForm {

    @NotEmpty(message = "Title is required")
    private String title;

    @NotNull(message = "Price is required")
    @Positive(message = "Input pisitive number")
    private Integer price;
    
}
