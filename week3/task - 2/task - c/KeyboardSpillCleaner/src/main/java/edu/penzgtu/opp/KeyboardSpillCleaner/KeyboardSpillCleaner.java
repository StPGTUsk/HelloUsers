package edu.penzgtu.opp.KeyboardSpillCleaner;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyboardSpillCleaner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку с возможными повторениями символов:");
        String input = scanner.nextLine();

        String cleanedInput = cleanRepeatedCharacters(input);
        System.out.println("Очищенная строка: " + cleanedInput);
    }

    public static String cleanRepeatedCharacters(String input) {
        String regex = "(.)\\1{1,2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("$1");
    }
}
