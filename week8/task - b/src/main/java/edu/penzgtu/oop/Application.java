package edu.penzgtu.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите список чисел через запятую ");
        String userInput = scanner.nextLine();
        List<Integer> data = stringToNumArray(userInput.split(","));

        MaxProfit profit = new MaxProfit();
        int result = profit.getMaxProfit(data);

        System.out.printf("Максимальная прибыль %d", result);

        scanner.close();
    }

    private static List<Integer> stringToNumArray(String[] strArrayList) {
        List<Integer> result = new ArrayList<>(strArrayList.length);

        for (String element : strArrayList) {
            result.add(Integer.parseInt(element));
        }

        return result;
    }
}
