package by.it.zhukova.jd02_06;

public class TaskA {
    public static void main(String[] args) {
        String exp="exception";
        Logger instance = Logger.getInstance();
        Logger.printException(exp);
        System.out.println(instance);
    }
}
