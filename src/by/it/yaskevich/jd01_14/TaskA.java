package by.it.yaskevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String path = getPath();
        String fileName = getFilePath("dataTaskA.bin");
        System.out.println(fileName);

        try (OutputStream out = new FileOutputStream(fileName);
             BufferedOutputStream bos = new BufferedOutputStream(out);
             DataOutputStream dos = new DataOutputStream(bos);) {

            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random() * 100));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>(20);
        try (DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)))) {

            while (dis.available() > 0) {
                list.add(dis.readInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double sum = 0;
        for (Integer value : list) {
            System.out.print( value + " ");
            sum += value;
        }
        System.out.println("avg=" + sum/list.size());


        try (
            PrintWriter out = new PrintWriter(
                    new FileWriter(getFilePath("dataTaskA.txt")))){

            for (Integer value : list) {
                out.print(value);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        System.out.println(root);

        String separator = File.separator;
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    private static String getFilePath(String fileName) {
        return getPath() + fileName;
    }

}
