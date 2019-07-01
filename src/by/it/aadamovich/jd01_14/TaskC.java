package by.it.aadamovich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class TaskC {


    public static void main(String[] args) {

        File rootDir = new File(getRootDirPath());
        String filePath = getThisDirPath() + "resultTaskC.txt";

        filePrint(rootDir);
        fileWrite(filePath);
    }

    private static ArrayList<String> arrayFiles = new ArrayList<>();

    private static void filePrint(File dir) {

        for (File file : Objects.requireNonNull(dir.listFiles())) {

            if (file.isDirectory()) {
                System.out.printf("dir:%s%n", file.getName());
                arrayFiles.add("dir:" + file.getName());
                if (file.list() != null) filePrint(file);
            } else {
                System.out.printf("file:%s%n", file.getName());
                arrayFiles.add("file:" + file.getName());
            }
        }
    }

    private static void fileWrite(String filePath) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filePath))
        ) {
            for (String element : arrayFiles) {
                pw.printf("%s%n", element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Class<TaskA> cls = TaskA.class;

    private static String getThisDirPath() {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName()
                .replace(cls.getSimpleName(), "")
                .replace(".", sep);
        return srcPath + classPath;
    }

    private static String getRootDirPath() {
        return new File(getThisDirPath()).getParent();
    }

}
