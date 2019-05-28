package by.it.izaykoff.jd01_07;

public class Runner {
    public static void main(String[] args) {

        String strVector = "{1.0,3.0,5.0}";

        String [] items = strVector.replaceAll("\\{","").replaceAll("[.0]","")
                .replaceAll("\\}","").split(",");



        System.out.println(items);
    }
}
