package by.it.guchek.jd01_15;

import java.io.*;

public class TaskB {
    //этот комментарий надо удалить

    /*бла бла бла
    бла бла
     */
    private static StringBuilder sb = new StringBuilder();

    /*бла бла бла
    бла бла
     */
    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    /**
     * Это Джавадок
     * Это Джавадок
     */
    private static String fileName = getPath(TaskB.class) + "TaskB.java";
    private static String fileName1 = getPath(TaskB.class) + "TaskB.txt";

    //этот комментарий надо удалить
    public static void main(String[] args) {

        readAndDeliteComment();

        writeCodeToFileTxt();

        System.out.println(sb);

    }

    private static void readAndDeliteComment() {
        try (BufferedReader bRead = new BufferedReader(new FileReader(fileName))) {

            boolean ignoreLine = false;
                                                                                 //Удали меня тоже
            String lineFrJava;

            while ((lineFrJava = bRead.readLine()) != null) {

                if (lineFrJava.contains("/" + "/")) {
                    sb.append(lineFrJava, 0, lineFrJava.indexOf("/" + "/")).append("\n");
                } else if (lineFrJava.contains("/" + "*")) {
                    sb.append(lineFrJava, 0, lineFrJava.indexOf("/" + "*")).append("\n");
                    ignoreLine = true;
                } else if (lineFrJava.contains("*" + "/")) {
                    ignoreLine = false;
                } else if (!ignoreLine) {
                    sb.append(lineFrJava).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeCodeToFileTxt() {
        try (PrintWriter prWrite = new PrintWriter(new FileWriter(fileName1))) {

            prWrite.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

