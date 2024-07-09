package com.bluemango.project_backend.models;

public class Product {
    
    //Atributes
    private int id;
    private String name; 
    private String desc;
    private double price;
    private int category; 
    private boolean promotion;
    private boolean novo; 

    // Constructor

    public Product(int id, String name, String desc, double price, int category, boolean promotion, boolean novo) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.category = 0;
        this.promotion = promotion; 
        this.novo = novo;
    }

    public Product(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getCategory() {
        return category;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public boolean isNovo() {
        return novo;
    }

    


    



    // Getters and Setters
    
    
    
}