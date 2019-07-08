package by.it.tbabich.jd01_12;

import java.util.*;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")){
            integerList.add(Integer.parseInt(line));
        }
        int index = 0;
        int start = 0;
        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) > 0){
                resultList.add(start, integerList.get(i));
                start++;
                index++;
            } else if (integerList.get(i) < 0){
                resultList.add(integerList.get(i));
            }
            else if (integerList.get(i) == 0){
                resultList.add(index, integerList.get(i));
            }
        }
        System.out.println(resultList.toString());

    }
}
