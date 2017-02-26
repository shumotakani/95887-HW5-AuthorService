package edu.shuwang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.shuwang.model.Author;

@RestController
public class AuthorController {
	@Autowired
	private AuthorAction authorAction;
	
	@RequestMapping("/api/author/{id}")
	public Author getAuthorById(@PathVariable Long id) {
		return authorAction.getAuthorById(id);
	}
	@RequestMapping("/api/author/byname")
	public Author getAuthorByName(@RequestParam("query") String query) {
		return authorAction.getAuthorByName(query);
	}
	@RequestMapping(value = "/api/author", method = RequestMethod.POST)
	public Long saveAuthor(@RequestBody String authorName) {
		return authorAction.saveAuthor(authorName);
	}
}
