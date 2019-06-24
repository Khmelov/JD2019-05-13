package by.it.livanovich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "livanovich";
    getName(path);

    }
        public static String getName (String path){
            try (PrintWriter out=new PrintWriter (new FileWriter(System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "livanovich"+File.separator +"jd01_14"+File.separator +"resultTaskC.txt",true))){

                File file=new File(path);
            for (File item : file.listFiles()) {
                if (item.isFile()){
                    System.out.printf("\nfile:%s",item.getName());
                    out.printf("\nfile:%s",item.getName());
                }
                else if (item.isDirectory()) {
                        System.out.printf("\ndir:%s",item.getName());
                    out.printf("\ndir:%s",item.getName());
                        getName(item.getPath());
                    }
                }
}
            catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        }

}
