package edu.penzgtu.opp.MedianFinder;

import java.util.Arrays;

public class MedianFinder {
    public static void main(String[] args) {
        double[] numbers = {1, 3, 3, 6, 7, 8, 9}; // Пример массива
        Arrays.sort(numbers); // Сортируем массив

        double median;
        int totalElements = numbers.length;
        if (totalElements % 2 == 0) {
            double sumOfMiddleElements = numbers[totalElements / 2] + numbers[totalElements / 2 - 1];
            // Для четного количества элементов медиана будет средним двух средних чисел
            median = sumOfMiddleElements / 2;
        } else {
            // Для нечетного количества элементов просто находим средний элемент
            median = numbers[numbers.length / 2];
        }

        System.out.println("Медиана: " + median);
    }
}