package edu.penzgtu.opp.AgeFormatter;

import java.util.Scanner;

public class AgeFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        System.out.println(age + " " + getAgeWord(age));
    }

    private static String getAgeWord(int age) {
        if (age % 100 >= 11 && age % 100 <= 19) {
            return "лет";
        }

        switch (age % 10) {
            case 1:
                return "год";
            case 2:
            case 3:
            case 4:
                return "года";
            default:
                return "лет";
        }
    }
}
