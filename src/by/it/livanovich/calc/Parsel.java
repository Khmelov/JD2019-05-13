package by.it.livanovich.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsel {

    private static final Map <String, Integer> priorMap=new HashMap<>();
    static {
        priorMap.put("=", 0);
        priorMap.put("+", 1);
        priorMap.put("-", 1);
        priorMap.put("*", 2);
        priorMap.put("/", 2);
    }

    private int getIndex (List <String> operations){
        int index=-1;
        int currentPrior=-1;
        for (int i = 0; i < operations.size(); i++) {
            String operation=operations.get(i);
            if (priorMap.get(operation)>currentPrior){
                currentPrior=priorMap.get(operation);
                index=i;
            }
        }
        return index;
    }

    private String oneOperation (String sOne, String operation, String sTwo) throws CalcException {
        Var two = Var.createVar(sTwo);
        if (operation.equals("=")) {
            Var.saveVar(sOne, two);
            return two.toString();
        }
        Var one = Var.createVar(sOne);

        switch (operation) {
            case ("+"):
                return one.add(two).toString();
            case ("-"):
                return one.sub(two).toString();
            case ("*"):
                return one.mul(two).toString();
            case ("/"):
                return one.div(two).toString();
        }
        throw new CalcException("Ошибка: неизвестная операция");
    }


    Var calc(String expression) throws CalcException {
        if (expression.equals("printvar")) {
            return null;
        }
        if (expression.equals("sortvar")) {
            return null;
        }
        expression = expression.replaceAll("\\s+", "");
        Pattern first=Pattern.compile("\\([^\\(].*?\\)");
        Matcher matcher=first.matcher(expression);
        while (matcher.find()){
        //    int start=matcher.start();
          //  int end=expression.indexOf(")");
            //String ex=expression.substring(start+1,end);
           // String op=calc(ex).toString();
         //   expression=expression.replace(ex,op).replace("(","").replace(")","");
            String ex=matcher.group();
            String expr=ex.replace("(","").replace(")","");
            String oper=calc(expr).toString();
            expression=expression.replace(ex,oper);
            matcher.reset(expression);
        }

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
        }
        while (operations.size() > 0) {
            int index=getIndex(operations);
            String sOne=operands.remove(index);
            String operation=operations.remove(index);
            String sTwo=operands.remove(index);
            String result=oneOperation(sOne,operation,sTwo);

            operands.add(index,result);
        }
        return Var.createVar(operands.get(0));
    }
}
