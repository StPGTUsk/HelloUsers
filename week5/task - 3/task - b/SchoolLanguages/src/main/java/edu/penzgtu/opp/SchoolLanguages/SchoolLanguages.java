package edu.penzgtu.opp.SchoolLanguages;

import java.util.*;

public class SchoolLanguages {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Set<String> commonLanguages = new HashSet<>();
        Set<String> allLanguages = new HashSet<>();
        boolean isFirstStudent = true;

        for (int i = 0; i < numberOfStudents; i++) {
            int numberOfLanguages = Integer.parseInt(scanner.nextLine());
            Set<String> currentLanguages = new HashSet<>();
            for (int j = 0; j < numberOfLanguages; j++) {
                String language = scanner.nextLine();
                currentLanguages.add(language);
                allLanguages.add(language);
            }

            if (isFirstStudent) {
                commonLanguages.addAll(currentLanguages);
                isFirstStudent = false;
            } else {
                commonLanguages.retainAll(currentLanguages);
            }
        }

        System.out.println(commonLanguages.size());
        commonLanguages.stream().sorted().forEach(System.out::println);

        System.out.println(allLanguages.size());
        allLanguages.stream().sorted().forEach(System.out::println);
    }
}
