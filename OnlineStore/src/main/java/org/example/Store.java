package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Store {
    private final List<Catalog> catalogs;
    private final ShoppingCart shoppingCart;

    public Store() {
        this.catalogs = new ArrayList<>();
        this.shoppingCart = new ShoppingCart();
    }

    public List<Catalog> getCatalogs() {
        return this.catalogs;
    }

    public ShoppingCart getShoppingCart() {
        return new ShoppingCart(this.shoppingCart);
    }

    public int getCatalogsCount() {
        return this.catalogs.size();
    }

    public void addCatalog(final Catalog catalog) {
        this.catalogs.add(catalog);
        System.out.println(catalog.getName() + " успешно добавлен в магазин.");
    }

    public void removeCatalog(final Catalog catalog) {
        this.catalogs.remove(catalog);
        System.out.println(catalog.getName() + " успешно удален из магазина.");
    }

    public Catalog getCatalog(final String name) {
        for (Catalog catalog : this.catalogs) {
            if (catalog.getName().equals(name)) {
                return catalog;
            }
        }
        return null;
    }

    public Catalog getCatalog(final int catalogNumber) {
        return this.catalogs.get(catalogNumber);
    }

    public void displayCatalogs() {
        System.out.println("Доступные каталоги:");
        for (int i = 0; i < this.catalogs.size(); i++) {
            Catalog catalog = this.catalogs.get(i);
            System.out.println((i + 1) + ". " + catalog.getName() + ".");
        }
    }

    public void displayProductsInCatalog(final Catalog catalog) {
        System.out.println("Доступные товары в каталоге " + catalog.getName() + ":");
        List<Product> products = catalog.getProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + ", Цена: " + product.getPrice() + " рублей.");
        }
    }

    public void displayProductsInCatalog(final String name) {
        Catalog catalog = this.getCatalog(name);
        this.displayProductsInCatalog(catalog);
    }

    public void displayProductsInShoppingCart() {
        System.out.println("Товары в корзине:");
        List<Product> products = this.shoppingCart.getItems();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + ", Цена: " + product.getPrice() + " рублей.");
        }
    }

    public void addToShoppingCart(final Product product) {
        this.shoppingCart.addItem(product);
        System.out.println(product.getName() + " успешно добавлен в корзину.");
    }

    public void removeFromShoppingCart(final Product product) {
        this.shoppingCart.removeItem(product);
        System.out.println(product.getName() + " успешно удален из корзины.");
    }

    public void removeFromShoppingCart(final int productNumber) {
        Product product = this.shoppingCart.getItems().get(productNumber);
        this.shoppingCart.removeItem(productNumber);
        System.out.println(product.getName() + " успешно удален из корзины.");
    }

    public boolean pay() {
        if (this.getShoppingCartItemsCount() == 0) {
            System.out.println("Нет товаров для оплаты.");
            return false;
        }
        double totalPrice, payment;
        totalPrice = this.shoppingCart.getTotalPrice();
        System.out.println("Общая сумма к оплате: " + totalPrice + " рублей.");
        System.out.println("Введите сумму платежа (введите 0, чтобы отменить процесс оплаты):");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        payment = scanner.nextDouble();
        if (payment == 0) {
            return false;
        }
        if (payment >= totalPrice) {
            double change = payment - totalPrice;
            System.out.println("Платеж успешно.");
            System.out.println("Оплачено.");
            System.out.println("Сдача: " + change + " рублей.");
            this.shoppingCart.clearItems();
            return true;
        }
        System.out.println("Недостаточная сумма платежа.\nПлатеж не прошел.");
        System.out.println("Не оплачено.");
        return false;
    }

    public void clearTheShoppingCart() {
        this.shoppingCart.clearItems();
        System.out.println("Корзина очищена.");
    }

    public int getShoppingCartItemsCount() {
        return this.shoppingCart.getItems().size();
    }
}
