package by.it.yaskevich.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        // ввод текста чере консоль или использовать готовый (нужное раскомментировать)
        String rawData = getRawData();
        //String rawData = getManualInputRawData();

        Map<Character, Character> brackets = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
                put('<', '>');
            }
        };
        Set<Character> closeBrackets = new HashSet<>(brackets.values());

        boolean brokenBrackets = false;
        LinkedList<Character> stackBrackets = new LinkedList<>();
        for (char symbol : rawData.toCharArray()) {
            if (brackets.containsKey(symbol)) {
                stackBrackets.push(symbol);
            } else if (closeBrackets.contains(symbol)) {
                if ((stackBrackets.peek() != null) && brackets.get(stackBrackets.peek()).equals(symbol)) {
                    stackBrackets.poll();
                } else {
                    brokenBrackets = true;
                    break;
                }
            }
        }

        System.out.println("Result: " + ((brokenBrackets || !stackBrackets.isEmpty()) ? "broken" : "normal"));
    }

    private static String getManualInputRawData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String getRawData() {
        return
            "public static void main(String[] args) {\n" +
            "    Map<Integer, String> map = getObjects();\n" +
            "\n" +
            "    System.out.printf(\"Before(%2d): %s\\n\" , map.size(), map);\n" +
            "\n" +
            "    Set<String> uniqueObjectsNames = new HashSet<>();\n" +
            "    Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();\n" +
            "    while (iterator.hasNext()) {\n" +
            "        if (!uniqueObjectsNames.add(iterator.next().getValue())) {\n" +
            "            iterator.remove();\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    System.out.printf(\"After (%2d): %s\\n\" , map.size(), map);\n" +
            "}\n";
    }
}
