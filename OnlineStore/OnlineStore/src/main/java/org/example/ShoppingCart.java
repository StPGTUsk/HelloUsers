package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items;
    private double totalPrice;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public ShoppingCart(final ShoppingCart shoppingCart) {
        this.items = new ArrayList<>(shoppingCart.getItems());
        this.totalPrice = 0.0;
    }

    public List<Product> getItems() {
        return this.items;
    }

    public void addItem(final Product product) {
        this.items.add(product);
    }

    public void removeItem(final Product product) {
        this.items.remove(product);
    }

    public void removeItem(final int productNumber) {
        this.items.remove(productNumber);
    }

    public double getTotalPrice() {
        this.totalPrice = 0.0;
        for (Product product : this.items) {
            this.totalPrice += product.getPrice();
        }
        return this.totalPrice;
    }

    public void clearItems() {
        this.items.clear();
    }
}
