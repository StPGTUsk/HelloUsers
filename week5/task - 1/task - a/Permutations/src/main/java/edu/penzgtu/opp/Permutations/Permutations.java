package edu.penzgtu.opp.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3); // Пример ввода
        List<List<Integer>> permutations = perms(numbers);
        System.out.println("Вывод: " + permutations);
    }

    public static List<List<Integer>> perms(List<Integer> numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }
        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);
            List<Integer> remaining = new ArrayList<>(numbers);
            remaining.remove(i);
            for (List<Integer> smallerPerms : perms(remaining)) {
                smallerPerms.add(0, current);
                result.add(smallerPerms);
            }
        }
        return result;
    }
}