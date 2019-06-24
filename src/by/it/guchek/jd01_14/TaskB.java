package by.it.guchek.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static File f = new File(dir(TaskB.class)+"text.txt");
    private static File f2 = new File(dir(TaskB.class)+"resultTaskB.txt");
    private static int countWords=0;
    private static int countPunct=0;


    private static String dir (Class<?> cl){  //прочитаем путь к файлам

        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String classDir =cl.getName().replace(cl.getSimpleName(), "").replace(".",File.separator);
        return path+classDir;
    }


    private static void printTextInConsoleFile(File f2, int words, int marks) { //продублируем вывод в консоль в файл
        try (
                PrintWriter prWrInFile = new PrintWriter(
                        new FileWriter(f2))
        ) {

            System.out.println(dir(TaskB.class));

            prWrInFile.print("words="+words+", punctuation marks="+marks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void fileReadMethod() {   //прочитаем из файла text.txt и высчитаем слова и знаки
        try (FileReader fileTextReader = new FileReader(f);
             BufferedReader bufferedReader =new BufferedReader(fileTextReader)){

            String strLine;

            while ((strLine=bufferedReader.readLine())!=null){

                //System.out.println(strLine);
                Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+"); //pattern описывающий все слова русского языка
                Matcher matcher = pattern.matcher(strLine);
                Pattern pattern1 = Pattern.compile("[:;!.,-]{1,3}"); //pattern описывающий все знаки препинания
                Matcher matcher1 = pattern1.matcher(strLine);

                while (matcher.find()){
                    countWords=countWords+1;

                }
                while (matcher1.find()){
                    countPunct=countPunct+1;

                }

            }

            System.out.println("words="+countWords+", punctuation marks="+countPunct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        fileReadMethod();
        printTextInConsoleFile(f2,countWords, countPunct);

    }
}
