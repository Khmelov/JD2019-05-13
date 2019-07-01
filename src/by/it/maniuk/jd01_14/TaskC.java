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
                    System.out.println("dir:" + item.getName());
                } else {
                    System.out.println("ile:" + item.getName());
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
                        writer.println(" file:" + item.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" dir:" + item.getName());

                } else {
                    try(PrintWriter writer = new PrintWriter(new FileWriter(txt))) {
                        writer.println("file:" + item.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    System.out.print("file:" + item.getName());
                }
            }
        }


    }

    private static String getFilePath(Class<TaskC> aClass, String filename) {
        return getPath2(aClass) + filename;
    }

    private static String getPath(Class<TaskC> aClass) {
        String separator = File.separator;


        String root = System.getProperty("user.dir")+ separator+ "src" + separator;
        String simpleName = aClass.getSimpleName();
        String name = TaskC.class.getName().replace(simpleName, "") .replace(".", separator);

        String path = name.replace(simpleName, "").replace(".", separator).replace("jd01_14",separator);



        path = root + separator + "src" + separator + path;

        return path;
    }
    private static String getPath2(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

}






