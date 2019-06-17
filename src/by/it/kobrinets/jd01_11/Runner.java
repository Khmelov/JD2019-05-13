package by.it.kobrinets.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

        public class Runner {
            public static void main(String[] args) {
                List<String> list=new ArrayList<>();
                list.add("one");
                list.add("two");
                list.add("three");
                list.add("four");

                System.out.println(list);
                System.out.println(list.get(1));
                list.remove(1);
                System.out.println(list);
                list.add(3,"five");
                System.out.println(list);

                List<String> listA=new ListA<>();
                listA.add("one");
                listA.add("two");
                listA.add("three");
                listA.add("four");

                System.out.println(listA);
                System.out.println(listA.get(1));
                listA.remove(1);
                System.out.println(listA);

                List<String> listB =new ListB<>();
                listB.add("one");
                listB.add("two");
                listB.add("three");
                listB.add("four");
                listB.addAll(listB);
                System.out.println(listB);

            }
        }