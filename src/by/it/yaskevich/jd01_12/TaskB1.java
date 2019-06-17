package by.it.yaskevich.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawData;
        StringBuilder text = new StringBuilder(1000);
        while (!"end".equals(rawData = scanner.nextLine())) {
            text.append(rawData).append('\n');
        }

        Map<String, Integer> words = new HashMap<>(125);

        String[] rawWords = text.toString().split("[\\s,:.;—/\"-]");
        for (String word : rawWords) {
            if (!word.isEmpty()) {
                if ("isn't".equals(word)) {
                    word = "don’t";
                }
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.printf("%s=%d\n", entry.getKey(), entry.getValue());
        }
    }
}
