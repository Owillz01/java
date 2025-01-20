package com.multiverse.snippet.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.multiverse.snippet.Model.Snippet;

@Service
public class SnippetService {
    private ArrayList<Snippet> snippetsList = new ArrayList();

    public SnippetService(){
        snippetsList.add(new Snippet(1, "Python", "print('Hello, World!')"));
        snippetsList.add(new Snippet(2, "Python", "def add(a, b):\n    return a + b"));
        snippetsList.add(new Snippet(3, "Python", "class Circle:\n    def __init__(self, radius):\n        self.radius = radius\n\n    def area(self):\n        return 3.14 * self.radius ** 2"));
        snippetsList.add(new Snippet(4, "JavaScript", "console.log('Hello, World!');"));
        snippetsList.add(new Snippet(5, "JavaScript", "function multiply(a, b) {\n    return a * b;\n}"));
        snippetsList.add(new Snippet(6, "JavaScript", "const square = num => num * num;"));
        snippetsList.add(new Snippet(7, "Java", "public class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, World!\");\n    }\n}"));
        snippetsList.add(new Snippet(8, "Java", "public class Rectangle {\n    private int width;\n    private int height;\n\n    public Rectangle(int width, int height) {\n        this.width = width;\n        this.height = height;\n    }\n\n    public int getArea() {\n        return width * height;\n    }\n}"));
    
    }

    public ArrayList<Snippet> getAllSnippets() {
        return snippetsList;
    }

   

    public Snippet addSnippet(Snippet snippet){
        int id = snippetsList.size();
        snippet.setId(id+1);
        snippetsList.add(snippet);
        return snippet;
    }

    public Snippet getSingleSnippet(int id){
        Snippet _snippet = null;
        // for (Snippet snippet : snippetsList) {
        //     if (snippet.getId() == id) {
        //         _snippet = snippet;
        //     }
        // }
        _snippet = snippetsList.stream().filter(snip -> snip.getId() == id).findFirst().orElse(null);
        return _snippet;
    }
}
