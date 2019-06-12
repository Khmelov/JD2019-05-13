package by.it.livanovich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        double [] arr={1,5,7};
        String str="{1, 2, 4}";
        Var v=new Vector(arr);
        System.out.println(v);
        Var v2=new Vector(str);
        System.out.println(v2);
    }
    }