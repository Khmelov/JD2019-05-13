package by.it.trudnitski.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Timofei Rudnitski
 * @version 1.0
 */
public class TaskB {

    public static void main(String[] args){
readFile(getPath(TaskB.class,"TaskB.java"));


    }

    /**
     *
     * @param filename
     * @throws IOException
     */

    private static void readFile(String filename){
        try(BufferedReader in=new BufferedReader(new FileReader((filename)));
            PrintWriter out2 = new PrintWriter(new FileWriter(getPath(TaskA.class) + "TaskB.txt"))) {
            List<String> file=new ArrayList<>();
            StringBuilder sb=new StringBuilder();



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
путь к это классу
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
