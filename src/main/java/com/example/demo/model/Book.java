package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //here by the lambok package getters and setters created
@Setter
@ToString

@Document(collection = "Book")
public class Book {
	
	@Id //here the primary key is 
	private int id;
	private String bookName;
	private String authorName;
	

}
