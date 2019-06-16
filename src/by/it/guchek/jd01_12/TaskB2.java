package by.it.guchek.jd01_12;

import java.util.*;

public class TaskB2 {
    static List <String> listArr = new ArrayList<>();
    static List <String> listLink = new LinkedList<>();
    static String process(ArrayList<String> peoples){
        return "0";
    };
    static String process(LinkedList<String> peoples){
        return "1";
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        Integer countPeople = scan.nextInt();

        String stroke;

        for (Integer i = 0; i < (int)(countPeople); i++) {

            stroke = scan1.nextLine();
            listArr.add(stroke);
            listLink.add(stroke);
        }

        System.out.println(listArr);
        System.out.println(listLink);
        boolean second=false;

        ListIterator<String> strListIt = listLink.listIterator();
        while (strListIt.hasNext()){
            String  next = strListIt.next();
            System.out.println(next);
            //System.out.println(next);
            //{if (next%2==0)
            if (second){strListIt.remove();
                    second=false;}
        else second=true;
        }
        System.out.println(listLink);
        ListIterator<String> strArrListIt = listArr.listIterator();


    }
}
