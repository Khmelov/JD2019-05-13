package by.it.maniuk.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        //write data
        String fileName = getFilePath(TaskA.class,"dataTaskA.bin");
        String txt = getFilePath(TaskA.class,"resultTaskA.txt");
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i <20 ; i++) {
                dos.writeInt((int) (Math.random()*25));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();
        //read data //print txt
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            PrintWriter writer = new PrintWriter(new FileWriter(txt))) {
            double sum=0;
            double count =0;
            while (dis.available()>0){

                int i = dis.readInt();
                list.add(i);

               System.out.print(i+" ");

                sum = sum+i;
                count++;
            }
            while (dis.available()>0){
                int i = dis.readInt();
               writer.print(i+" ");
}
            System.out.println("\n avg="+ sum/count);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //print console
        double sum=0;
        for (Integer integer : list) {
            System.out.printf("%d  ",integer);
            sum+=integer;
        }
        System.out.println("\n  avg=" + sum/list.size());



    }

    private static String getFilePath(Class<TaskA> aClass, String filename) {
        return  getPath(aClass) + filename;
    }

    private static  String getPath(Class<TaskA> aClass){
        String root = System.getProperty("user.dir");
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);

        path = root+separator+"src"+separator+path;
        return path;
    }
}

