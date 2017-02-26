package edu.shuwang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import edu.shuwang.model.Author;
import edu.shuwang.service.AuthorService;

@Service
public class AuthorAction {
	
	@Autowired
	private AuthorService authorService;
	
	@HystrixCommand(fallbackMethod = "getAuthorByIdFallback")
	public Author getAuthorById(Long id) {
		Author a = authorService.findById(id);
		return a;
	}
	
	@HystrixCommand(fallbackMethod = "getAuthorByNameFallback")
	public Author getAuthorByName(String query) {
		Author a = authorService.findByName(query);
		return a;
	}
	
	@HystrixCommand(fallbackMethod = "saveAuthorFallback")
	public Long saveAuthor(String authorName) {
		Author a = new Author(authorName);
		authorService.save(a);
		return a.getId();
	}
	
	public Author getAuthorByIdFallback(Long id) {
        return new Author("The system encounters a problem, execution failed");
    }
	
	public Author getAuthorByNameFallback(String query) {
        return new Author("The system encounters a problem, execution failed");
    }
	
	public Long saveAuthorFallback() {
        return null;
    }
	
	
}
