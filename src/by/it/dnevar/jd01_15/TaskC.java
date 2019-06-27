package by.it.dnevar.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        File file = new File(getPath(TaskC.class));

        Scanner sc=new Scanner(System.in);
        String line;
        System.out.print(file.getAbsolutePath()+">");
        while(!(line=sc.nextLine()).equals("end")){
            System.out.println();
            if(line.equals("cd ..")){
                file= new File(file.getParent());
                System.out.print("\n"+file.getAbsolutePath()+">");
            }
            if(line.equals("dir")){
                File[] files = file.listFiles();
                String fileOrDir="     ";
                for (int i = 0; i < files.length; i++) {
                    Date d = new Date(file.lastModified());
                    if(!files[i].isHidden()){
                        if(files[i].isDirectory()){
                            fileOrDir = "<DIR>";
                        }
                        System.out.printf("%-30s %5s    %10s\n",files[i].getName(),fileOrDir,d);
                    }

                }
                System.out.print("\n"+file.getAbsolutePath()+">");
            }
            if(line.contains("cd ")){
                File[] files = file.listFiles();
                String dirName = line.replace("cd ","");
                for (int i = 0; i < files.length; i++) {
                    if(!files[i].isHidden()&&files[i].isDirectory()&&(files[i].getName()).equals(dirName)){
                        file= files[i];
                        System.out.print("\n"+file.getAbsolutePath()+">");
                    }

                }
            }
        }

    }

    private static String getPath (Class<?> aClass){
        String root = System.getProperty("user.dir")
                + File.separator
                +"src"
                +File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+name;
    }

    private static String getFilePath(Class<?> aClass, String filename){
        return getPath(aClass)+filename;
    }
}
