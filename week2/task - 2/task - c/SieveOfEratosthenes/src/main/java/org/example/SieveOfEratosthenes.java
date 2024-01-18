package org.example;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 100; // Задайте предел до которого нужно найти простые числа
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Изначально предполагаем, что все числа простые
        isPrime[0] = false; // 0 не является простым числом
        isPrime[1] = false; // 1 не является простым числом

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // Отмечаем числа кратные i, начиная с i^2 как составные
                }
            }
        }

        // Выводим все простые числа
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}