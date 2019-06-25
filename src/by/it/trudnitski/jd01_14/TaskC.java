package by.it.trudnitski.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class TaskC {
    private static Set<String> allFiles = new TreeSet<>();

    private static void findFiles(File fileName) {
        File[] files = fileName.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("dir:" + file.getName());
                allFiles.add("dir:" + file.getName());
                if (file.length() >= 0)
                    findFiles(file);

            } else {
                System.out.println("file:" + file.getName());
                allFiles.add("file:" + file.getName());
            }

        }
    }


    public static void main(String[] args) {
        File path = new File(dirPath(TaskC.class));
        findFiles(path);
        try (FileWriter out = new FileWriter(getPath(TaskC.class) + "resultTaskC.txt")) {
            for (String allFile : allFiles) {
                out.write(allFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    private static String dirPath(Class<?> aClass) {
        return new File(getPath(aClass)).getParent();
    }
}
