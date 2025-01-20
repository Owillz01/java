package com.multiverse.snippet.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multiverse.snippet.Model.Snippet;
import com.multiverse.snippet.Service.SnippetService;

@RestController
@RequestMapping("/snippets")
public class SnippetController {
    @Autowired
    private SnippetService snippetService;

    @GetMapping("/")
    public ArrayList<Snippet> getAllSnippets(){
        return snippetService.getAllSnippets();
    }

    @PostMapping("/")
    public ResponseEntity<Snippet> createSnippet(@RequestBody Snippet snip){

        Snippet _snippetWithId = snippetService.addSnippet(snip);

        return new ResponseEntity<>(_snippetWithId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Snippet> getSingleSinppet(@PathVariable int id) {

        System.out.println(id+ "😫 Why Are Yu Not Visible?!!!!!!!!");
        Snippet res = snippetService.getSingleSnippet(id);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
     
}
