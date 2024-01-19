package edu.penzgtu.opp.MostFrequentChar;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentChar {

    public static Entry<Character, Integer> findMostFrequentChar(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCounts.put(ch, charCounts.getOrDefault(ch, 0) + 1);
        }

        Entry<Character, Integer> mostFrequent = null;
        for (Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (mostFrequent == null || entry.getValue() > mostFrequent.getValue()) {
                mostFrequent = entry;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        String input1 = "hello world";
        System.out.println("Результат: " + findMostFrequentChar(input1));

        String input2 = "aaa bbb cc";
        System.out.println("Результат: " + findMostFrequentChar(input2));
    }
}
