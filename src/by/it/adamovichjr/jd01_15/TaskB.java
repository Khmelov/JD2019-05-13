package by.it.adamovichjr.jd01_15;

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
        String javaFilePath = getFilePath("TaskB.java");
        String txtFilePath = getFilePath("TaskB.txt");
        copyFileWithoutComments(javaFilePath, txtFilePath);
    }

    private static StringBuilder sb = new StringBuilder();

    private static void copyFileWithoutComments(String readFilePath, String writeFileTxtPath) {
        try (BufferedReader br = new BufferedReader
                (new FileReader(readFilePath));
             PrintWriter pw = new PrintWriter
                     (new FileWriter(writeFileTxtPath))// не удалять
        ) {
            String line;
            /*
              бла-бла
             */
            boolean copyNextLine = true;
            while ((line = br.readLine()) != null) {
                if (line.contains("/"+"/")) {
                    int endIndex = line.indexOf("/"+"/");// все равно работать не будет
                    if (endIndex != 0) {
                        pw.write(sb.append(line, 0, endIndex).append("\n").toString());
                        sb.delete(0, sb.length());
                    }
                } else if (line.contains("/"+"*")) {
                    int endIndex = line.indexOf("/");
                    if (endIndex != 0) {
                        pw.write(sb.append(line, 0, endIndex).append("\n").toString());
                        sb.delete(0, sb.length());
                    }
                    copyNextLine = !copyNextLine;
                } else if (copyNextLine) {
                    pw.write(sb.append(line).append("\n").toString());
                    sb.delete(0, sb.length());
                } else if (line.contains("*"+"/")) {
                    copyNextLine = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    /**
     * бла-бла
     */
    private static Class<TaskA> cls = TaskA.class;

    private static String getFilePath(String name) {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + name;
    }
    /**
     * сюрприз
     *
     */
}