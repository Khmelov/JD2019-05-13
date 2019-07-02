package by.it.yaskevich.jd02_02;

class Printer {
    private Printer() {
    }

    synchronized static void print(String text) {
        System.out.println(text);
    }
}
