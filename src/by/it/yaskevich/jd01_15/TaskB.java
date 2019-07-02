package by.it.yaskevich.jd01_15;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.nio.file.Paths;

public class TaskB {
    /*
    * begin
    * */
    public static void main(String[] args) {
        StringBuilder code = readCode(); //read
        StringBuilder cleanCode = removeComments(code);
        printCleanCode(cleanCode);
        writeCleanCode(cleanCode); //write
    }

    private static void writeCleanCode(StringBuilder cleanCode) {
        /* все пишем в файл */
        try (PrintWriter out = new PrintWriter(
                new FileWriter(getFilePath("TaskB.txt")))) {
            out.println(cleanCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCleanCode(StringBuilder cleanCode) {
        System.out.println(cleanCode);
    }

    private static StringBuilder readCode() {
        StringBuilder code = new StringBuilder(1024);

        /* читаем из файла */
        try (BufferedReader br = new BufferedReader(
                new FileReader(getFilePath("TaskB.java")))){
            String rawData;
            while ((rawData = br.readLine()) != null) {
                code.append(rawData).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    private static StringBuilder removeComments(StringBuilder code) {
        StringBuilder newCode = new StringBuilder(code.length());

        StringReader sr = new StringReader(/* code */code.toString());
        try {
            boolean blockComment = false;
            boolean stringComment = false;
            boolean out = true;

            int previous = sr.read();
            int current;

            while ((current = sr.read()) != -1) { // cycle
                if(blockComment) {
                    if (previous == '*' && current == '/') {
                        blockComment = false;
                        out = false;
                    }
                } else if (stringComment) {
                    if (current == '\r') {
                        newCode.append((char)current).append((char)sr.read());
                        stringComment = false;
                        out = false;
                    }
                } else {
                    if (previous == '/' && current == '*') {
                        blockComment = true;
                    } else if (previous == '/' && current == '/') {
                        stringComment = true;
                    } else if (out){
                        newCode.append((char)previous);
                    } else {
                        out = true;
                    }
                }
                previous = current;
            }
            if (previous != -1 && out && !stringComment) {
                newCode.append((char)previous);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newCode;
    }

    private static String getFilePath(String fileName) {
        Class<?> aClass = MethodHandles.lookup().lookupClass();
        return Paths.get(
                System.getProperty("user.dir"), "src",
                aClass.getPackage().getName().replace(".", File.separator), fileName).toString();
    }
}
