package by.it.zhukova.jd01_15;
import java.io.*;
/**JavaDoc*/

public class TaskB {
    public static void main(String[] args) throws IOException {
        // многострочный 1.1
        // многострочный 1.2
        // многострочный 2.1
        // многострочный 2.2
        String fileJava = getFilePath(TaskB.class,"TaskB.java"); /*однострочный 1*/
        String fileTxt = getFilePath(TaskB.class, "TaskB.txt"); /*однострочный 2*/
        StringBuilder str = new StringBuilder();
        fileRead(fileJava, str);
        printFile(str,fileTxt);
    }
    private static void printFile(StringBuilder str, String fileTxt) throws IOException {
        try (
                PrintWriter out = new PrintWriter(new FileWriter(fileTxt))
        ) {  out.print(str);
            }
        }
    private static void fileRead(String fileJava, StringBuilder str) throws IOException {
        int b;
        char simbol;
        boolean del;
        int count=0;
        try (
            BufferedInputStream file = new BufferedInputStream(new FileInputStream(fileJava))
        )
        {
            del = false;
          while  ((b=file.read())>0){
              simbol= (char)b;
              if (simbol=='/' && count==2){
                  del=false;
                  count=0;
              }
              else if (simbol=='\n' && count==1){
                  del=false;
                  count=0;
                  str.append(simbol);
              }
             else if (simbol=='/') {
                 char c= (char) file.read();
                 if (c=='/')
                 {count=1;
                 del = true;
                 }
                 else if (c=='*') {
                     count=2;
                     del = true;

                 }
                 else str.append(simbol).append(c);
              }
              else if (del) continue;
             else str.append(simbol);
          }
            System.out.println(str);
        }

    }
    private static String getFilePath(Class<?> bClass, String filename) {
        String path = getPath(bClass);
        return path +filename;
    }
    private static String getPath(Class<?> bClass) {
        String src= System.getProperty("user.dir");
        String name = bClass.getName();
        String simpleName = bClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);
        path=src+separator+"src"+separator+path;
        return path;
    }
}
