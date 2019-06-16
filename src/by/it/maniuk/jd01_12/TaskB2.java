package by.it.maniuk.jd01_12;



import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       Random generator = new Random(15);
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        int[] ar= new int[n];
        for (int i = 0; i <n ; i++) {
            ar[i]=generator.nextInt(10);
        }
        for (int i = 0; i < n; i++) {
            arrayList.add("n" + ar[i]);
            linkedList.add("n" + ar[i]);
        }
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }

    static String process(ArrayList<String> peoples) {
        int count = 0;
        Iterator<String> it = peoples.iterator();
        while (peoples.size() > 1) {
            if (it.hasNext()) {
                it.next();
                count++;
                if (count == 2) {
                    it.remove();
                    count = 0;
                }
            } else {
                it = peoples.iterator();
            }
        }
        return peoples.toString();
    }
    static String process(LinkedList<String> peoples) {
        int count = 0;
        Iterator<String> it = peoples.iterator();
        while (peoples.size() > 1) {
            if (it.hasNext()) {
                it.next();
                count++;
                if (count == 2) {
                    it.remove();
                    count = 0;

                }
            } else {
                it = peoples.iterator();
            }
        }

        return peoples.toString();
    }
}


