package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static Store store;
    static Catalog laptops, smartphones;
    static Product laptop1, laptop2, smartphone1, smartphone2;

    private static void fourthMenu(final Catalog selectedCatalog) {
        int productAction;
        System.out.println("1) Оплатить.");
        System.out.println("2) Удалить конкретный товар из корзины.");
        System.out.println("3) Очистить корзину.");
        System.out.println("4) Назад.");
        productAction = scanner.nextInt();
        switch (productAction) {
            case 1 -> {
                if (store.pay()) {
                    mainMenu();
                } else {
                    fourthMenu(selectedCatalog);
                }
            }
            case 2 -> {
                store.displayProductsInShoppingCart();
                System.out.println("Введите номер товара, который нужно удалить из корзины:");
                int selectedProductNumberToRemove = scanner.nextInt();
                if (selectedProductNumberToRemove - 1 >= 0 && selectedProductNumberToRemove - 1 < selectedCatalog.getProductsCount()) {
                    store.removeFromShoppingCart(selectedProductNumberToRemove - 1);
                } else {
                    System.out.println("Неверный номер товара: " + selectedProductNumberToRemove);
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
                fourthMenu(selectedCatalog);
            }
            case 3 -> {
                store.clearTheShoppingCart();
                mainMenu();
            }
            case 4 -> {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                thirdMenu(selectedCatalog);
            }
            default -> {
                System.out.println("Неверный выбор действия: " + productAction);
                fourthMenu(selectedCatalog);
            }
        }
    }

    private static void thirdMenu(final Catalog selectedCatalog) {
        int productInput;
        System.out.println("1) Выбрать товары.");
        System.out.println("2) Назад.");
        productInput = scanner.nextInt();
        if (productInput == 1) {
            System.out.println("Выберите номера товаров (через пробел):");
            scanner.nextLine();
            String inputLine = scanner.nextLine();
            String[] indices = inputLine.split(" ");
            for (String indexStr : indices) {
                int index = Integer.parseInt(indexStr);
                if (index - 1 >= 0 && index - 1 < selectedCatalog.getProductsCount()) {
                    store.addToShoppingCart(selectedCatalog.getProduct(index - 1));
                } else {
                    System.out.println("Неверный номер товара: " + index);
                }
            }
            if (store.getShoppingCartItemsCount() > 0) {
                fourthMenu(selectedCatalog);
            } else {
                thirdMenu(selectedCatalog);
            }
        } else if (productInput == 2) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            secondMenu(selectedCatalog);
        } else {
            System.out.println("Неверный выбор действия: " + productInput);
            thirdMenu(selectedCatalog);
        }
    }

    private static void secondMenu(final Catalog selectedCatalog) {
        int catalogInput;
        System.out.println("1) Показать товары.");
        System.out.println("2) Назад.");
        catalogInput = scanner.nextInt();
        if (catalogInput == 1) {
            store.displayProductsInCatalog(selectedCatalog);
            thirdMenu(selectedCatalog);
        } else if (catalogInput == 2) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            mainMenu();
        } else {
            System.out.println("Неверный выбор действия: " + catalogInput);
            secondMenu(selectedCatalog);
        }
    }

    private static void mainMenu() {
        int userInput;
        System.out.println("1) Показать каталоги товаров.");
        System.out.println("2) Выход.");
        userInput = scanner.nextInt();
        if (userInput == 1) {
            store.displayCatalogs();
            System.out.println("Выберите номер каталога:");
            int catalogNumber = scanner.nextInt();
            if (catalogNumber - 1 >= 0 && catalogNumber - 1 < store.getCatalogsCount()) {
                Catalog selectedCatalog = store.getCatalog(catalogNumber - 1);
                secondMenu(selectedCatalog);
            } else {
                System.out.println("Неверный номер каталога: " + catalogNumber);
            }
        } else if (userInput == 2) {
            scanner.close();
            System.exit(0);
        } else {
            System.out.println("Неверный выбор действия: " + userInput);
        }
        mainMenu();
    }

    public static void main(String[] args) {
        System.out.println("Интернет-магазин электротехники.");
        scanner = new Scanner(System.in);
        store = new Store();
        laptops = new Catalog("Ноутбоки");
        laptop1 = new Product("Sony VAIO FE14", 69999.0);
        laptop2 = new Product("Apple MacBook Pro", 349999.0);
        laptops.addProduct(laptop1);
        laptops.addProduct(laptop2);
        smartphones = new Catalog("Смартфоны");
        smartphone1 = new Product("Samsung Galaxy S24", 97990.0);
        smartphone2 = new Product("Apple IPhone 15", 74990.0);
        smartphones.addProduct(smartphone1);
        smartphones.addProduct(smartphone2);
        store.addCatalog(laptops);
        store.addCatalog(smartphones);
        mainMenu();
    }
}