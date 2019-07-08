package by.it.aadamovich.jd02_06;

public class Runner {

    public static void main(String[] args) {

        Singleton logger = Singleton.LOGGER;
        int a = 10;
        int b, res;
        String message;
        boolean appendLoggerData = false;

        for (int i = 1; i < 11; i++) {
            b = (int) (Math.random() * 11);
            try {
                res = a / b;
                message = String.format("Операция %d: %d / %d = %d%n", i, a, b, res);
                System.out.println(message);
                logger.writeLog(message, appendLoggerData);
            } catch (ArithmeticException e) {
                e.printStackTrace();
                logger.writeLog(e, appendLoggerData, i);
            }

            if (!appendLoggerData) appendLoggerData = true;
        }
    }
}
