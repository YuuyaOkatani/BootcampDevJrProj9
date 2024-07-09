package com.bluemango.project_backend.models;

public class Category {
    
    //Attributes
    private int id;
    private String name;

    // Constructor
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    

    // Getters and Setters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    
    

    
}
