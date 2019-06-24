package by.it.yaskevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String fileName = getFilePath(TaskA.class, "dataTaskA.bin");

        writeData(fileName);

        List<Integer> list = new ArrayList<>(20);
        readData(fileName, list);
        printData(list);
        printDataCopy(getFilePath(TaskA.class, "resultTaskA.txt"), list);

        writeTextData(getFilePath(TaskA.class, "dataTaskA.txt"), list);
    }

    private static void printDataCopy(String fileName, List<Integer> list) {
        double sum = 0;
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (Integer value : list) {
                out.write(value + " ");
                sum += value;
            }
            out.write("\navg=" + sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeTextData(String fileName, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))){
            for (Integer value : list) {
                out.print(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printData(List<Integer> list) {
        double sum = 0;
        for (Integer value : list) {
            System.out.print(value + " ");
            sum += value;
        }
        System.out.println();
        System.out.println("avg=" + sum/list.size());
    }

    private static void readData(String fileName, List<Integer> list) {
        try (DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<TaskA> aClass) {
        String root = System.getProperty("user.dir");
        String separator = File.separator;
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        return root + separator + "src" + separator +
                name.replace(simpleName, "").replace(".", separator);
    }

    private static String getFilePath(Class<TaskA> aClass, String fileName) {
        return getPath(aClass) + fileName;
    }

}
