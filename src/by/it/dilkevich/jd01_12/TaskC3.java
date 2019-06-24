package by.it.dilkevich.jd01_12;

import java.util.List;
import java.util.Stack;

public class TaskC3 {

    public static void main(String[] args) {

        String text = "svsdvs ([{({})[]}])()[]{} {{{{kji[j]oi0j}}}}";
        boolean result = isStringIsCorrect(text);
        System.out.println(result);
    }


    private static boolean isStringIsCorrect(String text) {

        Stack<Character> a = new Stack<>();

        if (text.contains("(") || text.contains(")") || text.contains("[")
                || text.contains("]") || text.contains("{") || text.contains("}")) {

            char[] ch = text.toCharArray();

            for (int i = 0; i < ch.length; i++) {

                switch (ch[i]) {

                    case '(': {
                        if (a.empty() || a.peek() == '(' || a.peek() == '{' || a.peek() == '[')
                            a.push(ch[i]);
                        else if(a.peek() == ')'){
                            a.pop();
                        }
                        else return false;
                        break;
                    }

                    case '[': {
                        if (a.empty() || a.peek() == '(' || a.peek() == '{' || a.peek() == '[')
                            a.push(ch[i]);
                        else if(a.peek() == ']'){
                            a.pop();
                        }
                        else return false;
                        break;
                    }

                    case '{': {
                        if (a.empty() || a.peek() == '(' || a.peek() == '{' || a.peek() == '[')
                            a.push(ch[i]);
                        else if(a.peek() == '}'){
                            a.pop();
                        }
                        else return false;
                        break;
                    }
                    case ')': {
                        if(!a.empty() && a.peek() == '('){
                            a.pop();
                        }
                        else
                            return false;
                        break;
                    }
                    case ']': {
                        if(!a.empty() && a.peek() == '['){
                            a.pop();
                        }
                        else
                            return false;
                        break;
                    }
                    case '}': {
                        if(!a.empty() && a.peek() == '{'){
                            a.pop();
                        }
                        else
                            return false;
                        break;
                    }

                }
            }
        }
        if (a.empty()){
            return true;
        }
        else
            return false;
    }


}
