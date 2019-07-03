package by.it.maniuk.calc;


import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


class Printer {

    void print(Var result) {

        if (result != null) {
            System.out.println(result);

        }
    }
    static void printVar(){
        Set<Map.Entry<String, Var>> entrySet = Var.getVars().entrySet();
        for (Map.Entry<String, Var> varEntry : entrySet) {
            System.out.println(varEntry.getKey() + "=" +varEntry.getValue());
        }

    }
    static void sortVar(){
        Map<String, Var> sort = Var.getVars();
        Set<Map.Entry<String, Var>> entrySet = sort.entrySet();
        Iterator<Map.Entry<String, Var>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Var> me = iterator.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }

    }
    private static String getFilePath(Class<Printer> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<Printer> aClass) {
        String root = System.getProperty("user.dir");
        String name = Printer.class.getName();
        String simpleName = Printer.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }
}
