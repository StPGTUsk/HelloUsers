package edu.penzgtu.opp.SalesCalculator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Customer {
    private Long id;
    private String name;
    private Integer tier;

    // Getters, setters и toString опущены для краткости
}

class Order {
    Set<Product> products;
    private Long id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private Customer customer;

    // Getters, setters и toString опущены для краткости
}

class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;

    // Getters, setters и toString опущены для краткости
}

public class SalesCalculator {
    public static double calculateTotalSalesInFebruary2020(List<Order> orders) {
        double total = 0.0;
        LocalDate startFebruary2020 = LocalDate.of(2020, 2, 1);
        LocalDate endFebruary2020 = LocalDate.of(2020, 2, 29);

        for (Order order : orders) {
            if (isDateInFebruary2020(order.getOrderDate(), startFebruary2020, endFebruary2020)) {
                total += calculateTotalOrderValue(order.getProducts());
            }
        }

        return total;
    }

    private static boolean isDateInFebruary2020(LocalDate date, LocalDate start, LocalDate end) {
        return date != null && !date.isBefore(start) && !date.isAfter(end);
    }

    private static double calculateTotalOrderValue(Set<Product> products) {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setPrice(10.0);

        Product product2 = new Product();
        product2.setPrice(20.0);

        Order order1 = new Order();
        order1.setOrderDate(LocalDate.of(2020, 2, 15));
        order1.setProducts(new HashSet<>(Arrays.asList(product1, product2)));

        Order order2 = new Order();
        order2.setOrderDate(LocalDate.of(2020, 3, 10));
        order2.setProducts(new HashSet<>(Arrays.asList(product1)));

        Order order3 = new Order();
        order3.setOrderDate(LocalDate.of(2020, 2, 20));
        order3.setProducts(new HashSet<>(Arrays.asList(product2)));

        List<Order> orders = Arrays.asList(order1, order2, order3);

        System.out.println("Общая сумма продаж в феврале 2020: " + calculateTotalSalesInFebruary2020(orders));
    }
}