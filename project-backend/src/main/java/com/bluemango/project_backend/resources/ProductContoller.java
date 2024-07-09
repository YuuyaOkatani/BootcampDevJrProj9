package com.bluemango.project_backend.resources;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bluemango.project_backend.models.Category;
import com.bluemango.project_backend.models.Product;

import jakarta.annotation.PostConstruct;

@RestController
public class ProductContoller {

    private List<Product> products = new ArrayList<>();

    /*
     * 
     * 
     * private List<Product> products = Arrays.asList(
     * new Product(0, "Product 0", 0.0),
     * new Product(1, "Product 1", 10.0),
     * new Product(2, "Product 2", 20.0),
     * new Product(3, "Product 3", 30.0) // Adicionando mais produtos na lista
     * inicialmente
     * );
     * 
     * 
     */

    @GetMapping("product")
    public Product GetProduct() {

        Product p = new Product(0, null, "saas", 0.0, 1, false, false);
        // isso é mesmo empolgante
        /*
         * p.setId(0);
         * p.setNome(null);
         * p.setPrice(0);
         */
        return p;
    }

    // Ela inicializa a lista de produtos
    @PostConstruct
    public void init() {

        String[] NomesProd = {
            "ASUS ROG Strix Scar 18",
            "Acer Nitro 5 AN515-58-54UH",
            "Acer Nitro 5 AN515-58-54UH",
        };

        String[] DescProd ={
            "Intel Core i9-14900K",
            "Intel Core i5-14600KF",
             "Intel Core i5-13400"
        };

        double[] PrecosProd = {
            1000,
            800,
            700
        };

        int[] CategoriasProd = {
            1,
            2,
            3
        };

        boolean[] PromoProd = {
            true, false, false
        };

        boolean[] isNewProd = {
            true, true, false
        };



        for (int i = 0; i < 3; i++) {
            // Estou faznedo isso para não ficar muito feio
        
            Product p = new Product(
                i, 
                NomesProd[i], 
                DescProd[i], 
                PrecosProd[i], 
                CategoriasProd[i],
                PromoProd[i],
                isNewProd[i]
                
                );
            /*
             * p.setId(i);
             * p.setNome("Product " + i);
             * p.setPrice(i * 10);
             */
            products.add(p);
        }
        ;

    }

    @GetMapping("products")
    public List<Product> getProducts() {

        return products;
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable int id) {

        /*
         * if(id <= products.size()){
         * return ResponseEntity.ok((products.get(id-1)));
         * }
         * else{
         * 
         * 
         * throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
         * 
         * }
         */

        Product prod = products
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        return ResponseEntity.ok(prod);

    }

}
