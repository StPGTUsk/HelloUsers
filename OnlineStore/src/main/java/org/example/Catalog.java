package org.example;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private final List<Product> products;
    private String name;

    public Catalog(final String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public int getProductsCount() {
        return this.products.size();
    }

    public void addProduct(final Product product) {
        this.products.add(product);
    }

    public void removeProduct(final Product product) {
        this.products.remove(product);
    }

    public Product getProduct(final int productNumber) {
        return this.products.get(productNumber);
    }

    public Product getProduct(final String name) {
        for (Product product : this.products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
