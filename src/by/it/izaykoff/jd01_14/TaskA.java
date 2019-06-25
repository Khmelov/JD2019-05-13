package by.it.izaykoff.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {

        String fileData = getPath(TaskA.class, "dataTaskA.bin");
        String fileText = getPath(TaskA.class, "resultTaskA.txt");
        List<Integer> list = new ArrayList<>();

        writeData(fileData);
        readData(fileData, list);
        printConsole(list);
        printText(fileText, list);

    }

    private static void printText(String fileText, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(fileText))) {
            double sum = 0;
            for (Integer value : list) {
                out.printf("%d ", value);
                sum += value;
            }
            out.printf( Locale.ENGLISH,"\navg=%2f", sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printConsole(List<Integer> list) {
        double sum = 0;
        for (Integer value : list) {
            System.out.printf("%d ", value);
            sum += value;
        }
        System.out.printf(Locale.ENGLISH,"\navg=%2f", sum / list.size());
    }

    private static void readData(String fileData, List<Integer> list) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileData)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(String fileData) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileData)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getPath(Class<TaskA> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<TaskA> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }
}
