package by.it.yaskevich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class TaskC {
    public static void main(String[] args) {
        List<String> items = new LinkedList<>();
        scanDirectory(new File(getPath()),
                file -> items.add(file.isFile()? "file:" + file.getName() :
                        file.isDirectory() ? "dir:" + file.getName() : "unknown"));

        printItems(items);
        printItemsToFile(items, getFilePath(TaskC.class, "resultTaskC.txt"));
    }

    private static void printItemsToFile(List<String> items, String fileName) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(fileName))) {
            for (String item : items) {
                pw.println(item);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printItems(List<String> items) {
        items.forEach(System.out::println);
    }

    private static void scanDirectory(File item, Consumer<File> consumer) {
        if (item.isFile()) {
            consumer.accept(item);
        }else if (item.isDirectory()) {
            String name = item.getName();
            if (!".".equals(name) && !"..".equals(name)) {
                consumer.accept(item);
            }

            File[] files = item.listFiles();
            if (files != null) {
                for (File file : files) {
                    scanDirectory(file, consumer);
                }
            }
        }
    }

    private static String getFilePath(Class<?> aClass, String fileName) {
        String root = System.getProperty("user.dir");
        String separator = File.separator;
        String name = aClass.getName();
        return root + separator + "src" + separator +
                name.replace(aClass.getSimpleName(), "").replace(".", separator) + fileName;
    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        String separator = File.separator;
        return root + separator + "src\\by\\it\\yaskevich" + separator;
    }

}
