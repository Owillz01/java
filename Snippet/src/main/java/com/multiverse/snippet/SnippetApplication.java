package com.multiverse.snippet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.multiverse.snippet.Service.SnippetService;

@SpringBootApplication
public class SnippetApplication {

	public static void main(String[] args) {
		System.out.println("I RAN!!!");
		SpringApplication.run(SnippetApplication.class, args);
		SnippetService snippetService = new SnippetService();
	}

}
