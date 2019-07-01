package by.it.aadamovich.jd01_15;

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
//надо удалить
        String filenameRead = getFilePath("TaskB.java");
        String filenameWrite = getFilePath("TaskB.txt");

        readTaskNoComments(filenameRead); //Полный мусор
        writePrintTask(filenameWrite);
    }

    /* Совсем ненужная часть
    И это тоже удалить
    */
    private static StringBuilder sb = new StringBuilder();

    /**
     * Здесь должен быть нормальный код
     */
    private static void readTaskNoComments(String filenameRead) {
        try (BufferedReader br = new BufferedReader
                (new FileReader(filenameRead))
        ) {
            String line;
            boolean copyLine = true;
            while ((line = br.readLine()) != null) {
                if (line.contains("/" + "/")) {
                    sb.append(line, 0, line.indexOf("/" + "/")).append("\n");
                    /*
                      Комментарии излишни
                      Комментарии излишни
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
            Свои пять копеек
             */
        }
    }

    private static void writePrintTask(String filenameWrite) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filenameWrite))
        ) {
            pw.write(sb.toString());
            System.out.println(sb);
// Просто так
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
