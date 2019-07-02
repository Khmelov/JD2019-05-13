package by.it.trudnitski.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file=new File(getPath(TaskC.class));
        String line;
        System.out.println(file.getAbsolutePath()+">");
        while(!(line=sc.nextLine()).equals("end")){
            if (line.contains("cd")){
                line =  line.trim();
                String[] lines = line.split(" ");
                if (lines[0].equals("cd..") ){
                    file = new File(file.getParent());
                    System.out.println(file.getAbsolutePath());
                }
                else  {

                    StringBuilder sb = new StringBuilder(file.getAbsolutePath());
                    sb.append('/').append(lines[1]);
                    String list = sb.toString();
                    System.out.println(list);
                }
            }
            if(line.equals("dir")){
                File[]files=file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    SimpleDateFormat date=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    if(files[i].isDirectory()){
                   }
                    System.out.printf("%15s  <DIR>  %15s",date.format(files[i].lastModified()),files[i].getName());
               }
                System.out.println(file.getAbsolutePath()+">");
            }


        }
    }

    private static String getPath(Class<?> aClass, String filename) {
        return getPath(aClass) + filename;
    }

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
