package by.it.dnevar.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {

        String fileData = getFilePath(TaskA.class,"dataTaskA.bin");
        String fileTxt = getFilePath(TaskA.class,"resultTaskA.txt");

        writeData(fileData);
        List<Integer> list = new ArrayList<>();
        readData(fileData, list);
        printConsole(list);
        printTxt(fileTxt, list);

    }

    private static void printTxt(String fileTxt, List<Integer> list) {
        try(PrintWriter out = new PrintWriter(new FileWriter(fileTxt))){
            double sum = 0;
            for (Integer element : list) {
                out.printf("%d ",element);
                sum+=element;
            }
            out.printf(Locale.US,"\navg=%f",sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printConsole(List<Integer> list) {
        double sum = 0;
        for (Integer element : list) {
            System.out.printf("%d ",element);
            sum+=element;
        }
        System.out.printf(Locale.US,"\navg=%f",sum/list.size());
    }

    private static void readData(String fileData, List<Integer> list) {
        try(DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileData)
                )
            )
        ){
            while(dis.available()>0){
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(String fileData) {
        try(DataOutputStream dos = new DataOutputStream (
                new BufferedOutputStream(
                        new FileOutputStream(fileData)
                )
            )
        ){
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath (Class<?> aClass){
        String root = System.getProperty("user.dir")
                +File.separator
                +"src"
                +File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+name;
    }

    private static String getFilePath(Class<?> aClass, String filename){
        return getPath(aClass)+filename;
    }
}
