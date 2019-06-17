package by.it.dnevar.jd01_12;

import by.it.dnevar.jd01_02.TaskC;

import java.util.*;

public class TaskC3 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();

        String[] arrBracets = line.split("[^(){}\\[\\]]+");
        List<String> lineBracets = new ArrayList<>(Arrays.asList(arrBracets));
        Iterator<String> iterator = lineBracets.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            if(element.equals("")){
                iterator.remove();
            }
        }
        System.out.println(bracetsCorrect(lineBracets));

    }

    private static boolean bracetsCorrect(List<String> lineBracets) {
            if (lineBracets.isEmpty()) {
                return true;
            }

            LinkedList<String> buffer = new LinkedList<>();
            for (int i = 0; i < lineBracets.size(); i++) {

                String current = lineBracets.get(i);
                if (current.equals("{") || current.equals("(") || current.equals("[")) {
                    buffer.push(current);
                }


                if (current.equals("}") || current.equals(")") || current.equals("]")) {
                    if (buffer.isEmpty()) {
                        return false;
                    }

                    String last = buffer.peek();
                    if (current.equals("}") && last.equals("{")
                            || current.equals(")") && last.equals("(")
                            || current.equals("]") && last.equals("[")) {
                        buffer.pop();
                    }
                    else {
                        return false;
                    }
                }

            }

            return buffer.isEmpty();

    }
}
