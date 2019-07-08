package by.it.guchek.jd02_06.TaskA;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Logger {

    private static File logger = new File(dir(SomeExeptions.class)+"log.txt");

    private static volatile Logger instance;
    //конструктор класса
    private Logger() {
    }
    //метод доступа к экземпляру
    public static Logger getInstance() {
        Logger localInstance = instance; //попытка получить объект
        if (localInstance == null) { //первая проверка (для скорости)
            synchronized (Logger.class) {
                localInstance = instance; //вторая проверка для надежности
                if (localInstance == null) {
                    instance = localInstance = new Logger(); //создание
                }
            }
        }
        return localInstance; //возврат
    }


    private static String dir (Class<?> cl){  //прочитаем путь к файлам

        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String classDir =cl.getName().replace(cl.getSimpleName(), "").replace(".",File.separator);
        return path+classDir;

    }


    public static void printExeptionsOutLogFile(Exception err) { //продублируем ошибки в файл

        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Moscow"));

        try (
                PrintWriter prWrOutLogFile = new PrintWriter(
                        new FileWriter(logger, true))
        ) {

            prWrOutLogFile.append(zdt.toString()).append("\n");
            prWrOutLogFile.append(err.getClass().getName()).append(" ");
            prWrOutLogFile.append(err.getMessage()).append("\n");
            StackTraceElement[] stackTrace = err.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                prWrOutLogFile.append(element.toString()).append("\n");
            }
            prWrOutLogFile.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
