package by.it.yaskevich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pointZero = 0;
        String data;
        while (!"end".equals(data = scanner.next())) {
            Integer value = Integer.valueOf(data);
            if (value > 0) {
                numbers.add(pointZero++, value);
            } else if (value == 0) {
                numbers.add(pointZero, value);
            } else {
                numbers.add(value);
            }
        }
        System.out.println(numbers);
    }
}
