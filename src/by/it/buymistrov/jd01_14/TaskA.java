package by.it.buymistrov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {


        String filename = getFilePath(TaskA.class, "dataTaskA.bin");
        String filetext = getFilePath(TaskA.class, "resultTaskA.txt");


        //write
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {

            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Integer> list = new ArrayList<>();
        //read
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        //print
        double sum = 0;
        for (Integer integer : list) {
            System.out.print(integer + " ");
            sum += integer;
        }

        System.out.println();
        System.out.println("avg = "+ sum/list.size());

        //printfile
        try(PrintWriter out = new PrintWriter(new FileWriter(filetext))) {
            //        double sum = 0;
//        for (Integer integer : list) {
//            System.out.print(integer + " ");
//            sum += integer;
//        }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        double sum = 0;
//        for (Integer integer : list) {
//            System.out.print(integer + " ");
//            sum += integer;
//        }
//
//        System.out.println();
//        System.out.println("avg = "+ sum/list.size());


    }


    private static String getPath(Class<TaskA> aClass) {
        String root = System.getProperty("user.dir");
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;

    }

    private static String getFilePath(Class<TaskA> aClass, String filename) {
        return getPath(aClass) + filename;
    }

}
