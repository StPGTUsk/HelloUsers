package edu.penzgtu.oop;


import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значения через пробел ");
        String userInput = scanner.nextLine();
        List<Integer> data = stringToNumArray(userInput.split(" "));

        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.perms(data);

        System.out.println("Результат: ");
        System.out.println(result);

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
