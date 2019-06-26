package by.it.trudnitski.jd01_15;

import java.io.*;

/**
 * @author Timofei Rudnitski
 * @version 1.0
 */
public class TaskB {
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args){
readFile(getPath(TaskB.class,"TaskB.java"));
writeFile(getPath(TaskB.class,"TaskB.txt"));


    }

    /**
     *
     * @param filename
     * @throws IOException
     */

    private static void readFile(String filename) {
        try(BufferedReader in=new BufferedReader(new FileReader((filename)))
            ) {
            boolean flag=true;
            String line;
            while((line=in.readLine())!=null) {
                if (line.contains("/" + "/")) {
                    sb.append(line, 0, line.indexOf("/" + "/")).append("\n");
                } else if (line.contains("/" + "*")) {
                    sb.append(line, 0, line.indexOf("/" + "*")).append("\n");
                    flag = false;
                } else if (line.contains("*" + "/")) {
                    flag = false;
                } else if (flag) {
                    sb.append(line).append("\n");
                }
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    private static void writeFile(String filename){
        try(PrintWriter print=new PrintWriter(new FileWriter(filename))){
            print.write(sb.toString());
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
Метод getPath на вход получает заданный класс
и имя нужного файла
 */
    private static String getPath(Class<?> aClass, String filename) {
        return getPath(aClass) + filename;
    }
/*
Этот метод getPath на вход получает
заданный класс а возвращает
 */
    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        //Получаем строку с адресов в корень каталога
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
        //Возвращает путь к файлу
    }
}
