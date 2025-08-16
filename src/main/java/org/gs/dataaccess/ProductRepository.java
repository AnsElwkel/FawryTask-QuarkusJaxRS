package org.gs.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProductRepository {
    List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        fillProducts();
    }
    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int id) throws NoSuchElementException{
        Optional.ofNullable(getProduct(id)).ifPresentOrElse(product ->
            products.remove(product)
         ,
                NoSuchElementException::new);
    }

    public Product getProduct(int id){
        return products
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateProduct(int id , String name , String description , double price) throws NoSuchElementException{
        Optional.ofNullable(getProduct(id)).ifPresentOrElse(product ->
        {
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
        } ,
                NoSuchElementException::new);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private void fillProducts(){
        products.add(new Product("Laptop",1, "High performance laptop", 1200.00));
        products.add(new Product("Smartphone",2, "Latest model smartphone", 800.00));
        products.add(new Product("Tablet",3, "Portable tablet device", 300.00));
        products.add(new Product("Smartwatch",4, "Feature-rich smartwatch", 200.00));
        products.add(new Product("Headphones",5, "Noise-cancelling headphones", 150.00));
    }
}
