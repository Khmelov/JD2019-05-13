package by.it.lasotskaya.jd01_13;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){

        String line;
        double rez;
        try{
            double sum=0;
            Scanner sc = new Scanner(System.in);
            while (!(line = sc.next()).equals("END")){
                rez = Double.parseDouble(line);
                sum = sum + rez;
                if (rez<0) throw new ArithmeticException();
                else{
                    rez = Math.sqrt(sum);
                    System.out.println(rez);
                }
            }
        }
        catch (NumberFormatException | NullPointerException |ArithmeticException ex){
            String name = ex.getClass().getName();
            StackTraceElement[] stackTrace = ex.getStackTrace();
            for (StackTraceElement st:stackTrace){
                if (TaskB.class.getName().equals(st.getClassName())){
                    String classname = st.getClassName();
                    int number = st.getLineNumber();
                    System.out.printf("name: %s\n" + "class: %s\n"+"line: %d",name, classname,number);
                    break;
                }

            }
        }
    }
}


