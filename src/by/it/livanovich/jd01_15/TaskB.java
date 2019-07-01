package by.it.livanovich.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskB {
    public static void main(String[] args) throws IOException {
        //однострочный комментарий1
        //односточный комментарий2
       /* многосторочный
                комментраррий номер один*/
       /* многосторочный
                комментраррий номер два*/
        /** а это
                комментрий JavaDoc*/
        //Files.lines(Paths.get(dir(TaskB.class)+"TaskB.java")).filter(s->!(s.contains("//"))).collect(Collectors.toList()).forEach(System.out::println);
        try (PrintWriter out=new PrintWriter(new FileWriter(dir(TaskB.class)+"TaskB.txt"));
             BufferedInputStream in =new BufferedInputStream(new FileInputStream(dir(TaskB.class)+"TaskB.java"))){
            int b=0;
            char aschar;
            StringBuilder sb=new StringBuilder();
            while (in.available()>0){
                b=in.read();
                aschar=(char)b;
                if (aschar=='/'){
                    aschar=(char)in.read();
                    if (aschar=='/'){
                        do {
                            aschar=(char)in.read();
                        }
                        while (aschar!='\n');
                    }
                    else if (aschar=='*'){
                        do {
                            aschar=(char)in.read();
                        }
                        while (aschar!='/');
                        aschar=(char)in.read();
                    }
                    else sb.append('/');
                }
                sb.append(aschar);
            }
            out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String dir(Class<?> cl) {
        String scr = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        String path=scr+classDir;
        return path;

    }
}
