package by.it.yaskevich.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        // ввод объектов чере консоль или использовать готовый набор (нужное раскомментировать)
        Map<Integer, String> map = getObjects();
        //Map<Integer, String> map = getManualInputObjects();

        System.out.printf("Before(%2d): %s\n" , map.size(), map);

        Set<String> uniqueObjectsNames = new HashSet<>();
        map.entrySet().removeIf(entry -> !uniqueObjectsNames.add(entry.getValue()));

        System.out.printf("After (%2d): %s\n" , map.size(), map);
    }

    private static Map<Integer, String> getManualInputObjects(){
        Map<Integer, String> map = new TreeMap<>(Integer::compareTo);

        Scanner scanner = new Scanner(System.in);

        String rawData;
        int generatedNumber = 1;
        while (!"end".equals(rawData = scanner.nextLine())) {
            map.put(generatedNumber++, rawData);
        }

        return map;
    }

    private static Map<Integer, String> getObjects() {
        return new TreeMap<Integer, String>(Integer::compareTo) {
                {
                    int generatedNumber = 1;

                    put(generatedNumber++, "Бананы");
                    put(generatedNumber++, "Киви");
                    put(generatedNumber++, "Мандарины");
                    put(generatedNumber++, "Лимон");
                    put(generatedNumber++, "Апельсины");
                    put(generatedNumber++, "Ананас");
                    put(generatedNumber++, "Киви");
                    put(generatedNumber++, "Абрикосы");
                    put(generatedNumber++, "Мандарины");
                    put(generatedNumber++, "Сливы");
                    put(generatedNumber++, "Яблоки");
                    put(generatedNumber, "Киви");
                }
            };
    }
}
