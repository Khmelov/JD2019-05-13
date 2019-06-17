package by.it.buymistrov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {

    private static boolean isBalanced(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('{', '}');
        pair.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (pair.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (pair.containsValue(s.charAt(i))) {
                if (stack.isEmpty())
                    return false;
                if (pair.get(stack.pop()) != s.charAt(i))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        System.out.println(isBalanced(text));

    }
}
