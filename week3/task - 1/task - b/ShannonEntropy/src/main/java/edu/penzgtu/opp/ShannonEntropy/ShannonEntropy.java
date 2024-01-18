package edu.penzgtu.opp.ShannonEntropy;

import java.util.HashMap;
import java.util.Map;

public class ShannonEntropy {
    public static void main(String[] args) {
        String input = "TEST STRING test string";
        double entropy = calculateEntropy(input);
        System.out.printf("Энтропия: %.2f\n", entropy);
    }

    public static double calculateEntropy(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        double entropy = 0.0;
        int len = input.length();
        for (int freq : frequencyMap.values()) {
            double probability = (double) freq / len;
            entropy -= probability * (Math.log(probability) / Math.log(2));
        }
        return entropy;
    }
}