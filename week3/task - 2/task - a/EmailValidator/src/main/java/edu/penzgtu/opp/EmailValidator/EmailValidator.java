package edu.penzgtu.opp.EmailValidator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес электронной почты для проверки:");
        String email = scanner.nextLine();

        if (isValidEmail(email)) {
            System.out.println(email + " - это действительный адрес электронной почты.");
        } else {
            System.out.println(email + " - это недействительный адрес электронной почты.");
        }
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
