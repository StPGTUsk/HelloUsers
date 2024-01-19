package edu.penzgtu.opp.FileSearcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileSearcher {

    public static void searchFiles(File dir, String searchQuery) throws IOException {
        if (!dir.isDirectory()) {
            System.out.println("Путь не является директорией: " + dir.getAbsolutePath());
            return;
        }

        List<File> files = Files.walk(Paths.get(dir.getAbsolutePath()))
                .filter(Files::isRegularFile)
                .map(path -> path.toFile())
                .collect(Collectors.toList());

        for (File file : files) {
            if (file.getName().contains(searchQuery) || containsText(file, searchQuery)) {
                System.out.println("Найден файл: " + file.getAbsolutePath());
            }
        }
    }

    private static boolean containsText(File file, String text) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(text)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + file.getAbsolutePath());
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            File directory = new File("/home/alllcryx/Рабочий стол/labworks/week6/task - 3"); // Укажем путь к директории
            String searchQuery = "Привет!"; // Укажем строку поиска
            searchFiles(directory, searchQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}