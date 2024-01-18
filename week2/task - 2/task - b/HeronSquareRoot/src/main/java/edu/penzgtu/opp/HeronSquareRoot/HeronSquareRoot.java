package edu.penzgtu.opp.HeronSquareRoot;

public class HeronSquareRoot {
    public static void main(String[] args) {
        double number = 16; // число, для которого нужно найти квадратный корень
        double epsilon = 1e-10; // погрешность для проверки сходимости
        double guess = number / 2; // начальное предположение для квадратного корня

        while (Math.abs(guess * guess - number) > epsilon) {
            guess = (guess + number / guess) / 2;
        }

        System.out.println("Квадратный корень из числа " + number + " равен " + guess);
    }
}
