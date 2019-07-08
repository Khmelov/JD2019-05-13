package by.it.yaskevich.calc;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Locale;

public enum Logger {
    INSTANCE;

    public void log(String text) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(getFilePath("log.txt"), true)))) {
            out.printf("%s %s\n", getDateTimeNow(), text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDateTimeNow() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault());
        if (dateFormat instanceof SimpleDateFormat) {
            ((SimpleDateFormat) dateFormat).applyPattern("yyyy-MM-dd HH:mm:ss");
        }
        return dateFormat.format(Date.from(Instant.now()));
    }

    private static String getFilePath(String fileName) {
        Class<?> aClass = MethodHandles.lookup().lookupClass();
        return Paths.get(
                System.getProperty("user.dir"), "src",
                aClass.getPackage().getName().replace(".", File.separator), fileName).toString();
    }

}
