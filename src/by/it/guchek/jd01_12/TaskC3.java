package by.it.guchek.jd01_12;

import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {
    static boolean isCorrect(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); ++i) {
            Character c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (isCorrect(input)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}


