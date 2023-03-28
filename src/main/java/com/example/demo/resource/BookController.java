package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	//adding book rest api
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "Added book with id: "+book.getId();
	}
	//get all books rest api
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		return repository.findAll();
	}
	
	//get all books by id rest api
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		return repository.findById(id);
	}
	
	//delete all by id rest api
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book with id:"+id+" deleted";
	}
	
	//update all by id rest api
	@PutMapping("/update/{id}")
	public String updateBook(@PathVariable int id,@RequestBody Book book) {
		Book updateBook = repository.findById(id).orElseThrow(()->new RuntimeException("Item not found."));// runtime exception is not necessary
		
		updateBook.setBookName(book.getBookName());
		updateBook.setAuthorName(book.getAuthorName());
		
		repository.save(updateBook);
		return "Book updated successfully";
	}
	
	//PathVariable is to locate the item
	//RequestBody is to take the json or any other data as an object
	//@XxxxMapping("address") this 'address' is route to the particular rest api

}
