package by.it.buymistrov.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = TaskC.class.getName();
        String simpleName = TaskC.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    public static void main(String[] args) {

        File file = new File(getPath());
        File[] files;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        String expression;
        String up;

        while (!(expression = scanner.nextLine()).equals("end")) {

            if (expression.equals(("dir"))) {
                files = file.listFiles();
                assert files != null;
                for (File fileRek : files) {
                    if (fileRek.isFile()) {
                        System.out.println(sdf.format(fileRek.lastModified())
                                + " "
                                + " <file> "
                                + " "
                                + fileRek.length()
                                + " " + fileRek.getName());
                    } else if (fileRek.isDirectory()) {
                        System.out.println(sdf.format(fileRek.lastModified())
                                + " "
                                + " <DIR> "
                                + " "
                                + fileRek.length()
                                + " "
                                + fileRek.getName());
                    }
                }
                System.out.println();
            }

            if (expression.startsWith(("cd"))) {
                up = expression.replaceAll("cd", "").trim();
                if (up.startsWith("..")) {
                    file = file.getParentFile();
                } else {
                    file = new File(file.toString() + "/" + up);
                }
            }
        }
    }
}
