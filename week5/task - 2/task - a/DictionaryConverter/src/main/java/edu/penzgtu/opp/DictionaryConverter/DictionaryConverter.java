package edu.penzgtu.opp.DictionaryConverter;

import java.util.*;

public class DictionaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> latinToEnglish = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" - ");
            String englishWord = parts[0];
            String[] latinWords = parts[1].split(", ");

            for (String latinWord : latinWords) {
                latinToEnglish.computeIfAbsent(latinWord, k -> new ArrayList<>()).add(englishWord);
            }
        }

        System.out.println(latinToEnglish.size());
        for (Map.Entry<String, List<String>> entry : latinToEnglish.entrySet()) {
            Collections.sort(entry.getValue());
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }
    }
}
