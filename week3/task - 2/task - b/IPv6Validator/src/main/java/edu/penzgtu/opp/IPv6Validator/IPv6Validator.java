package edu.penzgtu.opp.IPv6Validator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPv6Validator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес IPv6 для проверки:");
        String ipv6Address = scanner.nextLine();

        if (isValidIPv6(ipv6Address)) {
            System.out.println(ipv6Address + " - это действительный полный IPv6-адрес.");
        } else {
            System.out.println(ipv6Address + " - это недействительный IPv6-адрес.");
        }
    }

    public static boolean isValidIPv6(String ipv6Address) {
        String ipv6Regex = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
        Pattern pattern = Pattern.compile(ipv6Regex);
        Matcher matcher = pattern.matcher(ipv6Address);
        return matcher.matches();
    }
}
