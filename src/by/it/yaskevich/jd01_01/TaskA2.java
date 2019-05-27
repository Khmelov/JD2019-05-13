package by.it.yaskevich.jd01_01;

/*
напишите тело main программы которая выводит на экран 5 строк
"Я начинаю изучать Java!"

Для ручной проверки запустите программу Ctrl+Shift+F10
Для автоматической проверки откройте и запустите класс Testing
*/

class TaskA2 {

    public static void main(String[] args) {
        final int COUNTER = 5;
        for (int i = 0; i < COUNTER; i++) {
            System.out.println("Я начинаю изучать Java!");
        }
    }
}
