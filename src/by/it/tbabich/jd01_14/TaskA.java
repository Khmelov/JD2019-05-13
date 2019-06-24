package by.it.tbabich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String fileName = getFilePath(TaskA.class, "dataTaskA.bin");
        String fileData = getFilePath(TaskA.class, "resultTaskA.txt");

        //write data
        writeData(fileName);

        List<Integer> list = new ArrayList<>();

        //read data
        readData(fileName, list);

        //printConsole
        printConsole(list);

        //printText
        printText(fileData, list);
    }

    private static void printText(String fileData, List<Integer> list) {
        try (
                PrintWriter printWriter = new PrintWriter(
                        new FileWriter(fileData))
        ) {
            double summ = 0;
            for (Integer integer : list) {
                printWriter.print(integer + " ");
                summ += integer;
            }
            String avg = String.format("\navg=%f", summ / list.size()).replace(",", ".");
            printWriter.printf(avg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printConsole(List<Integer> list) {
        double summ = 0;
        for (Integer integer : list) {
            System.out.print(integer + " ");
            summ += integer;
        }
        String avg = String.format("\navg=%f", summ / list.size()).replace(",", ".");
        System.out.printf(avg);
    }

    private static void readData(String fileName, List<Integer> list) {
        try (
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(fileName)))
        ) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(String fileName) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName))
                );
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<TaskA> aClass) {
        String root = System.getProperty("user.dir");
        String simpleName = TaskA.class.getSimpleName();
        String name = TaskA.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

    private static String getFilePath(Class<TaskA> aClass, String fileName) {
        return getPath(aClass) + fileName;
    }
}
