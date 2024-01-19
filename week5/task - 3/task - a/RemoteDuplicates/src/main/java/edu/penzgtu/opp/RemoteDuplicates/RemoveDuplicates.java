package edu.penzgtu.opp.RemoteDuplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Integer[] numbers = {2, 2, 3, 4, 4, 5, 5, 6, 7}; // Пример входного массива
        Integer[] uniqueNumbers = removeDuplicates(numbers);

        System.out.println("Массив без дубликатов: " + Arrays.toString(uniqueNumbers));
    }

    public static Integer[] removeDuplicates(Integer[] numbers) {
        Set<Integer> set = new HashSet<>(Arrays.asList(numbers));
        return set.toArray(new Integer[0]);
    }
}
