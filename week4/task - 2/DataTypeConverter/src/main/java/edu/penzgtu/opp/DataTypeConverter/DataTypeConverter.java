package edu.penzgtu.opp.DataTypeConverter;

import java.util.Scanner;

public class DataTypeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение для преобразования:");
        String input = scanner.nextLine();

        System.out.println("Выберите тип для преобразования: 1 - Число, 2 - Логический тип (boolean)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: // Преобразование в число
                try {
                    int number = Integer.parseInt(input);
                    System.out.println("Преобразованное число: " + number);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка преобразования: Введенная строка не является числом.");
                }
                break;

            case 2: // Преобразование в логический тип
                if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                    boolean boolValue = Boolean.parseBoolean(input);
                    System.out.println("Преобразованное логическое значение: " + boolValue);
                } else {
                    System.out.println("Ошибка преобразования: Введенная строка не является логическим значением (true или false).");
                }
                break;

            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите 1 или 2.");
                break;
        }
    }
}
