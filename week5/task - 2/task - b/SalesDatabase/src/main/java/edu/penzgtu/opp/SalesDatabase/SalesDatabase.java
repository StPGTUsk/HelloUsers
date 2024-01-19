package edu.penzgtu.opp.SalesDatabase;

import java.util.*;

public class SalesDatabase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, Integer>> salesData = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            String customer = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            salesData.computeIfAbsent(customer, k -> new TreeMap<>())
                    .merge(product, quantity, Integer::sum);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> customerEntry : salesData.entrySet()) {
            System.out.println(customerEntry.getKey() + ":");
            for (Map.Entry<String, Integer> productEntry : customerEntry.getValue().entrySet()) {
                System.out.println(productEntry.getKey() + " " + productEntry.getValue());
            }
        }
    }
}