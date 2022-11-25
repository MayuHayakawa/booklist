package com.example.booklist_app.entity;

import javax.persistence.*;

import lombok.Data;

// // For registorer book's information in the database
// @Data
// @Entity
// @Table(name = "booksinfo")
// public class Book {
    
//     @Id
// 	@GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Integer id;

//     private String title;
    
//     private Integer price;
// }

@Data
@Entity
@Table(name = "booksinfo")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	// 本のidを保持するフィールド
	private Integer id;
	
	@Column(name="title")
	// 本のタイトルを保持するフィールド
	private String title;
	
	
	@Column(name="price")
	// 本の値段を保持するフィールド
	private Integer price;
}
