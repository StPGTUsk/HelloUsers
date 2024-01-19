package edu.penzgtu.opp.FibonacciClassic;

public class FibonacciClassic {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 7; // Пример числа Фибоначчи
        System.out.println("Число Фибоначчи для " + n + " равно: " + fibonacci(n));
    }
}
