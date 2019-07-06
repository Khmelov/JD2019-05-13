package by.it.lasotskaya.jd02_06;

public class TaskA {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        for (int i = 0; i < 200; i++) {
            logger.toLog("Message №"+i);
        }
    }
}
