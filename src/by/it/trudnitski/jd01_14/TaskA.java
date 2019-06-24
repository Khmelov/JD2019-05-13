package by.it.trudnitski.jd01_14;

import java.io.*;

public class TaskA {

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    public static void main(String[] args) {

        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(getPath(TaskA.class) + "dataTaskA.bin")))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(getPath(TaskA.class) + "dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(new FileWriter(getPath(TaskA.class) + "resultTaskA.txt"))) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                System.out.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
            out2.print("\navg=" + sum / count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
