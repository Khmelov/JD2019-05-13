package by.it.zhukova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {
        String fileData = getFilePath(TaskA.class, "dataTaskA.bin");
        String fileTxt = getFilePath(TaskA.class, "resultTaskA.txt");
        writeData(fileData);
        List<Integer> list = new ArrayList<>();
        readData(fileData, list);
        printConsole(list);
        printFile(fileTxt, list);
    }

    private static void printFile(String fileTxt, List<Integer> list) {
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(fileTxt))
        ){
            double sum = 0;
            for (Integer value : list) {
                printWriter.printf("%d ", value);
                sum += value;
            }
            printWriter.printf(Locale.ENGLISH,"\navg=%.3f\n", sum/list.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printConsole(List<Integer> list) {
        double sum = 0;
        for (Integer value : list) {
            System.out.printf("%d ", value);
            sum += value;
        }
        System.out.printf(Locale.ENGLISH,"\navg=%.3f\n", sum/list.size());
    }

    private static void readData(String fileData, List<Integer> list) {
        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(fileData)))
        ) {
            while (dis.available() > 0)
                list.add(dis.readInt());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(String fileData) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileData)))
        ) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getFilePath(Class<?> aClass, String filename) {
        String path = getPath(aClass);
       return path +filename;
    }

    private static String getPath(Class<?> aClass) {
        String src= System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);
        path=src+separator+"src"+separator+path;
        return path;
    }
}
