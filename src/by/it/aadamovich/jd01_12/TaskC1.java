package by.it.aadamovich.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {

        Map<Integer, String> elements = createList();

        System.out.println(elements);

        deleteDuplicates(elements);

        System.out.println(elements);
    }


    private static Map<Integer, String> createList() {
        Map<Integer, String> bufferElements = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String line;
        Integer code;

        while (!(line = sc.next()).equals("end")) {
            // Checking if code is unique
            do code = random.nextInt(1000000); while (bufferElements.containsKey(code));
            bufferElements.put(code, line);
        }
        return bufferElements;
    }

    private static void deleteDuplicates(Map<Integer, String> elements) {
        Set<String> uniqueObjects = new HashSet<>();
        Iterator<Map.Entry<Integer, String>> iterator = elements.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (uniqueObjects.contains(entry.getValue())) {
                iterator.remove();
            } else {
                uniqueObjects.add(entry.getValue());
            }
        }
    }
}





