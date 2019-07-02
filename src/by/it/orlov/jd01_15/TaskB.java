package by.it.orlov.jd01_15;

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
//минус
        String filenameRead = getFilePath("TaskB.java");
        String filenameWrite = getFilePath("TaskB.txt");

        readTaskNoComments(filenameRead); //минус
        writePrintTask(filenameWrite);
    }

    private static StringBuilder sb = new StringBuilder();

    /**
     * Место кода
     */
    private static void readTaskNoComments(String filenameRead) {
        try (BufferedReader br = new BufferedReader
                (new FileReader(filenameRead))
        ) {
    /* Полностью
    удалить
    */
            String line;
            boolean copyLine = true;
            while ((line = br.readLine()) != null) {
                if (line.contains("/" + "/")) {
                    sb.append(line, 0, line.indexOf("/" + "/")).append("\n");
                    /*
                      Комментарий1
                      Комментарий2
                     */
                } else if (line.contains("/" + "*")) {
                    sb.append(line, 0, line.indexOf("/" + "*")).append("\n");
                    copyLine = !copyLine;
                } else if (line.contains("*" + "/")) {
                    copyLine = !copyLine;
                } else if (copyLine) {
                    sb.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            /*
            ком
             */
        }
    }

    private static void writePrintTask(String filenameWrite) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filenameWrite))
        ) {
            pw.write(sb.toString());
            System.out.println(sb);
// 1234
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Class<TaskB> cls = TaskB.class;

    private static String getFilePath(String name) {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + name;
    }
}
