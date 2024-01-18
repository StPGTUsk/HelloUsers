package edu.penzgtu.opp.MaxCount;

public class MaxCount {
    public static void main(String[] args) {
        double[] numbers = {1, 5, 10, 10, 0, -10}; // Исходный массив чисел
        double maxNumber = numbers[0]; // Предполагаем, что максимальное число - это первый элемент массива
        int count = 1; // Количество максимальных чисел в массиве

        // Поиск максимального числа
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
                count = 1; // Сбрасываем счетчик, так как нашли новое максимальное число
            } else if (numbers[i] == maxNumber) {
                count++; // Увеличиваем счетчик, если нашли еще одно число, равное максимальному
            }
        }

        // Вывод количества максимальных чисел
        System.out.println("Количество чисел, равных максимальному: " + count);
    }
}