package by.it.dnevar.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line;
        Double sum = 0.0;
        while(!(line=sc.next()).equals("END")){

            try {
                sum += parseLine(line);
                System.out.println("Корень квадратный суммы: " + getSqrt(sum));
            } catch(NumberFormatException | ArithmeticException e){
            String name = e.getClass().getName();
            String className = TaskB.class.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement elem: stackTrace) {
                    if((elem.getClassName()).equals(className)){
                        System.out.printf(""+
                            "  name: %s\n" +
                            " class: %s\n" +
                            "  line: %d\n",name,className,elem.getLineNumber());
                        break;
                    }
                }
            }
        }
    }

    private static Double getSqrt(Double sum) throws ArithmeticException{
        if(sum>0){
            return Math.sqrt(sum);
        }else{
            throw new ArithmeticException();
        }
    }

    private static Double parseLine(String line) throws NumberFormatException {
        double res = Double.parseDouble(line);
        System.out.println(res);
        return res;
    }
}
