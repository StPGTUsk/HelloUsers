package edu.penzgtu.opp.SubstringCounter;

public class SubstringCounter {
    public static void main(String[] args) {
        String toFind = "аа"; // Подстрока для поиска, используем кириллические символы "аа"
        String[] searchIn = {"ааба", "абаба", "cgаааer"}; // Строки для поиска, используем кириллическую "а"

        int count = 0; // Счётчик вхождений

        for (String str : searchIn) {
            int index = 0;
            while ((index = str.indexOf(toFind, index)) != -1) {
                count++;
                index += toFind.length(); // Перемещаем индекс на длину искомой подстроки
            }
        }

        System.out.println("Количество вхождений одной строки в других: " + count);
    }
}