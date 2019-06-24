package by.it.dilkevich.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {

        String path = "E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\jd01_15\\TaskB.java";
        String pathToTextFile = "E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\jd01_15\\TaskB.txt";

        StringBuilder stringBuilder = new StringBuilder();

        //1
        // 2
        /* kljji*/
        /* kljjifbdf*/

        /**
         *
         *
         **/

        String text = deleteAllComments(path, stringBuilder);
        wrtiteToFile(text, pathToTextFile);
    }




    private static void wrtiteToFile(String text, String pathToTextFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToTextFile))){

            bufferedWriter.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String deleteAllComments(String path, StringBuilder stringBuilder) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String line = "svsdvs";
            boolean isSymbolStart = false;
            boolean isJavaDocStart = false;

            do {
               line =  bufferedReader.readLine();

               if(isSymbolStart == true && line != null){

                   if(line.contains("*/")){

                       int end = line.indexOf("*/")+2;

                       String lineToDelete = line.substring(0, end);
                       line = line.replace(lineToDelete, "");
                       isSymbolStart = false;
                   }
                   else {

                       String lineToDelete = line.substring(0, line.length());
                       line = line.replace(lineToDelete, "");
                   }
               }

                else if(isJavaDocStart == true && line != null){

                    if(line.contains("**/")){

                        int end = line.indexOf("**/")+3;

                        String lineToDelete = line.substring(0, end);
                        line = line.replace(lineToDelete, "");
                        isJavaDocStart = false;
                    }
                    else {

                        line = "";
                    }
                }

               else if (line != null && line.contains("//") && !line.contains("\"//\"")){

                       int start = line.indexOf("//");
                       String lineToDelete = line.substring(start, line.length());
                       line = line.replace(lineToDelete, "");
               }

               else if (line != null && line.contains("/**") && isJavaDocStart == false && !line.contains("(\"*/\")") && !line.contains("(\"/**\")")){

                   int start = line.indexOf("/**");

                   if(line.contains("**/")) {

                       int end = line.indexOf("**/")+3;

                       String lineToDelete = line.substring(start, end);
                       line = line.replace(lineToDelete, "");
                   }
                   else {

                       String lineToDelete = line.substring(start, line.length());
                       line = line.replace(lineToDelete, "");
                       isJavaDocStart = true;
                   }
               }

               else if (line != null && line.contains("/*") && isSymbolStart == false && !line.contains("(\"/*\")") && !line.contains("/**")) {

                   int start = line.indexOf("/*");

                   if(line.contains("*/")) {

                       int end = line.indexOf("*/")+2;

                       String lineToDelete = line.substring(start, end);
                       line = line.replace(lineToDelete, "");
                   }
                   else {
                       String lineToDelete = line.substring(start, line.length());
                       line = line.replace(lineToDelete, "");
                       isSymbolStart = true;
                   }
               }

                if (line != null)
               stringBuilder.append(line).append("\n");

            }
            while (line != null);

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
