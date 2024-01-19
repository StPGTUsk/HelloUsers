package FibonacciOptimized;

import java.util.HashMap;
import java.util.Map;

public class FibonacciOptimized {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        int n = 7; // Пример числа Фибоначчи
        System.out.println("Число Фибоначчи для " + n + " равно: " + fibonacci(n));
    }
}
