package by.it.maniuk.jd01_14;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TaskC {
    public static void main(String[] args) {
        File dir = new File("D:/JD2019-05-13/src/by/it/maniuk");
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    getFiles(item);
                    System.out.println("\t dir:" + item.getName());
                } else {
                    System.out.println("\t file:" + item.getName());
                }
            }
        }
    }

    private static void getFiles(File files) {

        String txt = getFilePath(TaskC.class,"resultTaskC.txt");
        File dir2 = new File(String.valueOf(files));
        if (dir2.isDirectory()) {
            for (File item : dir2.listFiles()) {

                if (item.isDirectory()) {
                    try(PrintWriter writer = new PrintWriter(new FileWriter(txt))) {
                        writer.println("\t file:" + item.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\t dir:" + item.getName());

                } else {
                    try(PrintWriter writer = new PrintWriter(new FileWriter(txt))) {
                        writer.println("\t file:" + item.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\t file:" + item.getName());
                }
            }
        }


    }

    private static String getFilePath(Class<TaskC> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<TaskC> aClass) {
        String root = System.getProperty("user.dir");
        String name = TaskC.class.getName();
        String simpleName = TaskC.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }
}






