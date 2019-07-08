package by.it.tbabich.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.writeLog("Test");
        logger.closeLogger();
    }
}
