package com.example.booklist_app.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class EditBookForm {
    
    @NotNull(message = "ID is Null")
    private Integer id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Price is required")
    @Positive(message = "Input pisitive number")
    private Integer price;

}
