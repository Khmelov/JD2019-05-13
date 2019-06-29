package by.it.guchek.jd01_15;

import java.io.*;

public class TaskB {
    //этот комментарий надо удалить

    /*бла бла бла
    бла бла
     */
    private static StringBuilder sb= new StringBuilder();
    private static StringBuilder sb1= new StringBuilder();
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
    private static String fileName = getPath(TaskB.class)+"TaskB.java";
    private static String fileName1 = getPath(TaskB.class)+"TaskB.txt";
    //этот комментарий надо удалить
    public static void main(String[] args) {

        try (BufferedReader bRead = new BufferedReader(new FileReader(fileName))) {
            String lineFrJava;
            boolean ignoreLine = false;

            while (bRead.ready()) {
                lineFrJava = bRead.readLine();

                if (lineFrJava.contains("/" + "/") || lineFrJava.contains("/" + "*") || lineFrJava.contains("/" + "**")) {
                    sb1.append("", 0, 0).append("\n");
                    if (lineFrJava.contains("/" + "/")) {
                        ignoreLine = false;
                    } else ignoreLine = true;
                } else if (lineFrJava.contains("*" + "/")) {
                    sb1.append("", 0, 0).append("\n");
                    ignoreLine = false;
                } else if (!ignoreLine) {
                    sb1.append(lineFrJava).append("\n");
                } else sb1.append("", 0, 0).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter prWrite = new PrintWriter(new FileWriter(fileName1))){

           prWrite.write(sb1.toString());
           System.out.println(sb1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
