package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Переменные для подсчёта
        int currentCount = 0;
        int maxCount = 0;

        try {
            // Читаем содержимое файла как список строк
            String content = String.join("", Files.readAllLines(Path.of("xyz.txt"), StandardCharsets.UTF_8));

            // Используем стримы для обработки символов
            for (int i = 0; i < content.length(); i++) {
                if (content.charAt(i) == 'X') {
                    currentCount++;
                    maxCount = Math.max(maxCount, currentCount);
                } else {
                    currentCount = 0;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Выводим результат
        System.out.println(maxCount);
    }
}