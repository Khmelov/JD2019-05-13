package by.it.yaskevich.calc;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class ReportBuilder {
    String name;
    List<String> data = new ArrayList<>();
    List<String> events = new ArrayList<>();
    List<String> exceptions = new ArrayList<>();

    String getDateNow() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        return dateFormat.format(Date.from(Instant.now()));
    }

    abstract void buildName();

    void buildData(String text) {
        data.add(getDateNow() + " " + text);
    }

    abstract void buildEvent(String event);

    abstract void buildException(Exception exception);

    void build(String fileName) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(getFilePath(fileName))))) {
            out.println(name);
            out.println();
            for (String datum : data) {
                out.println(datum);
            }
            out.println();
            out.println("Events");
            for (String event : events) {
                out.println(event);
            }
            out.println();
            out.println("Exceptions");
            for (String exception : exceptions) {
                out.println(exception);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(String fileName) {
        Class<?> aClass = MethodHandles.lookup().lookupClass();
        return Paths.get(
                System.getProperty("user.dir"), "src",
                aClass.getPackage().getName().replace(".", File.separator), fileName).toString();
    }
}
