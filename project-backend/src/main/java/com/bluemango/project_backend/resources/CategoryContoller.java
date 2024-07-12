package com.bluemango.project_backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bluemango.project_backend.models.Category;

import jakarta.annotation.PostConstruct;



@CrossOrigin
@RestController
public class CategoryContoller {

    List<Category> categories = new ArrayList<>();

    @PostConstruct
    public void init(){
        String[] nomes = {
            "Produção própria",
            "Nacional",
            "Importado",
            "Premium",
           
        };

        for(int i=0; i<nomes.length; i++){
            Category c = new Category(i + 1, nomes[i]); 
            categories.add(c);
        }

    }

    @GetMapping("categories")
    public List<Category> getCategories(){
        return categories;
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategories(@PathVariable int id){
        Category cat = categories
        .stream()
        .filter(c -> c.getId() == id).
        findFirst()   
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        return ResponseEntity.ok(cat);
        
   }

    
}

