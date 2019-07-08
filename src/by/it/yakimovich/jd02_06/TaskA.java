package by.it.yakimovich.jd02_06;

public class TaskA {
    public static void main(String[] args) {
        Logger log = Logger.loggingError();
        for (int i = 1; i < 11; i++) {
            log.toLog("Error № "+i);
        }
    }

}
