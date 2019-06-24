package by.it.buymistrov.jd01_14;

import java.io.*;

public class TaskC {

    private static String filePath = getPath();
    private static String fileOutPath = getFilePath();

    private static String getFilePath() {
        return getPath() + "resultTaskC.txt";
    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    private static void tree(File file, PrintWriter out) {

        File[] files = file.listFiles();
        assert files != null;
        for (File fileRek : files) {
            if (fileRek.isFile()) {
                out.println("file:" + fileRek.getName());
                System.out.println("file:" + fileRek.getName());
            } else if (fileRek.isDirectory()) {
                out.println("dir:" + fileRek.getName());
                System.out.println("dir:" + fileRek.getName());
                tree(fileRek, out);
            }
        }
    }

    public static void main(String[] args) {

        try (PrintWriter out = new PrintWriter(
                new FileWriter(fileOutPath))) {
            File file = new File(filePath).getParentFile();
            tree(file, out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
