package by.it.livanovich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TaskA {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {
        List <Integer> list=new ArrayList<>();
        try (DataOutputStream dos=new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")))){
            for (int i = 0; i <20 ; i++) {
                dos.writeInt((int)(Math.random()*100));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (DataInputStream dis=new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
        PrintWriter out=new PrintWriter (new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))) {
            double sum=0;

            while (dis.available()>0){
                int i=dis.readInt();
                sum+=i;
                list.add(i);
            }
            double avg=sum/list.size();
            for (Integer el: list) {
                System.out.print(el+" ");
                out.print(el+" ");
            }
            System.out.printf(Locale.ENGLISH,"\navg=%f",avg);
            out.printf(Locale.ENGLISH,"\navg=%f",avg);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}