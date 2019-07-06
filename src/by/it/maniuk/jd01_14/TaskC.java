package by.it.maniuk.jd01_14;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


public class TaskC {
    public static void main(String[] args) {
        File dir = new File(getPath2(TaskC.class));
        if (dir.isDirectory()) {
            for (File item : Objects.requireNonNull(dir.listFiles())) {
                if (item.isDirectory()) {
                    getFiles(item);
                    System.out.println("dir:" + item.getName());
                } else {
                    System.out.println("ile:" + item.getName());
                }
            }
        }
    }

    private static void getFiles(File files) {

        String txt = getFilePath(TaskC.class,"resultTaskC.txt");
        File dir2 = new File(String.valueOf(files));
        if (dir2.isDirectory()) {
            for (File item : Objects.requireNonNull(dir2.listFiles())) {

                if (item.isDirectory()) {
                    try(PrintWriter writer = new PrintWriter(new FileWriter(txt))) {
                        writer.println(" file:" + item.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" dir:" + item.getName());
                    getFiles(item);
                } else {
                    try(PrintWriter writer = new PrintWriter(new FileWriter(txt))) {
                        writer.println("file:" + item.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("file:" + item.getName());
                }
            }
        }


    }

    private static String getFilePath(Class<TaskC> aClass, String filename) {
        return  getPath(aClass) + filename;
    }

    private static  String getPath(Class<TaskC> aClass){
        String root = System.getProperty("user.dir");
        String name = TaskC.class.getName();
        String simpleName = TaskC.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);

        path = root+separator+"src"+separator+path;
        return path;
    }

    private static String getPath2(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator).replace("jd01_14", "");
        path = root + separator + "src" + separator + path;
        return path;
    }

}


//public class TaskC {
//
//    private static String filePath = getPath();
//    private static String fileOutPath = getFilePath();
//
//    private static String getFilePath() {
//        return getPath() + "resultTaskC.txt";
//    }
//
//    private static String getPath() {
//        String root = System.getProperty("user.dir");
//        String name = TaskB.class.getName();
//        String simpleName = TaskB.class.getSimpleName();
//        String separator = File.separator;
//        String path = name.replace(simpleName, "").replace(".", separator);
//        path = root + separator + "src" + separator + path;
//        return path;
//    }
//
//    private static void tree(File file, PrintWriter out) {
//
//        File[] files = file.listFiles();
//        assert files != null;
//        for (File fileRek : files) {
//            if (fileRek.isFile()) {
//                out.println("file:" + fileRek.getName());
//                System.out.println("file:" + fileRek.getName());
//            } else if (fileRek.isDirectory()) {
//                out.println("dir:" + fileRek.getName());
//                System.out.println("dir:" + fileRek.getName());
//                tree(fileRek, out);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//        try (PrintWriter out = new PrintWriter(
//                new FileWriter(fileOutPath))) {
//            File file = new File(filePath).getParentFile();
//            tree(file, out);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}




