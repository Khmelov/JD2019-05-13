package by.it.guchek.jd01_14;

import java.io.*;

public class TaskA {
    private static String dir (Class<?> cl){

        String path=System.getProperty("user.dir")+File.separator+"src"+File.separator;
        //определяет где находится каталог проекта
        // D:\Drivers for Notebook\projects\JD2019-05-13_1
        String classDir =cl.getName().replace(cl.getSimpleName(), "").replace(".",File.separator);
        return path+classDir;
    }

    public static void main(String[] args) {
        //String root = System.getProperty("user.dir"); получить каталог
        //System.out.print(root);
        //System.out.println(dir(TaskA.class));
        //String name = TaskA.class.getName();
        //String simpleName = TaskA.class.getSimpleName();
        //String separator = File.separator;
        //String path = name.replace(simpleName, "").replace(".", separator);
        System.out.println(dir(TaskA.class));
        DataOutputStream dOuSt= null;
        try {//создадим файловый поток
            dOuSt=new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")
                    ));
            for (int i = 0; i <20 ; i++) {
                dOuSt.writeInt((int) (Math.random()*18));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (dOuSt != null){
                try {
                    dOuSt.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } //Заменим на try с ресурсами доступный с 7 версии для потока вывода

        DataInputStream dInSt= null;
        try {//создадим файловый поток
            dInSt=new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")
                    ));
            PrintWriter out2= new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"));
            double sum=0;
            double count=0;
            while (dInSt.available()>0){

                int i= dInSt.readInt();
                //System.out.printf("%d ",i);
                System.out.print(i+" ");
                out2.write(i+" ");
                sum=sum+i;
                count++;
            }
            System.out.print("\navg="+sum/count);
            out2.write("\navg="+sum/count);
            out2.close();

            } catch (IOException ex) {
            ex.printStackTrace();
        }

        finally {
            if (dInSt != null){
                try {
                    dInSt.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } //Заменим на try с ресурсами доступный с 7 версии для потока вывода

    }
}
