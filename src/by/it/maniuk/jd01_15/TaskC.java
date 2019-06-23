package by.it.maniuk.jd01_15;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {
    private static File dir;

    public static void main(String[] args) throws IOException {

        dir = new File("D:/JD2019-05-13/src/by/it/maniuk/jd01_15/");
        dir = dir.getCanonicalFile();
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("by/it/maniuk/jd01_15/");
        while (!( s = scanner.nextLine()).equals("end")){

            if (s.contains("cd")){
                s =  s.trim();
               String[] line = s.split(" ");
               if (line[0].equals("cd..") ){
                dir = new File(dir.getParent());
                System.out.println(dir.getAbsolutePath());
                getContents(dir);}
                else  {

                    StringBuilder sb = new StringBuilder(dir.getAbsolutePath());
                    sb.append('/').append(line[1]);
                    String list = sb.toString();
                   dir = new File(String.valueOf(list));
                   getContents(dir);
               }
            }
            if (s.contains("dir")){
                getContents(dir);
            }

        }
    }

    private static void getContents(File dir) {

        for (File item : Objects.requireNonNull(dir.listFiles())) {
            if (item.isDirectory()) {
                SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                System.out.printf("%-10s   <DIR>   %10d     %-10s\n", sdf.format(item.lastModified()),getFileDir(item), item.getName());
            } else {
                SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                System.out.printf("%-10s            %10d    %-10s\n", sdf.format(item.lastModified()),item.length() ,item.getName());
            }
        }
    }
    private static int getFileDir(File item) {
        String[] list;
        list =item.list();
        return list.length;
    }



}
