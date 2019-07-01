package by.it.tbabich.jd01_15;

public class Runner {
    public static void main(String[] args) {
        String s = "    //Получить путь к классу";
        boolean isComment = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (((int) chars[i] == 47 && (int) chars[i + 1] == 47)) isComment = true;
        }
        if (isComment) System.out.println("!");
        else System.out.println("&");
    }
}
