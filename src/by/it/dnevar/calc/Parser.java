package by.it.dnevar.calc;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Map<String, Integer> priorMap = new HashMap<>();

    static {
        priorMap.put("=",0);
        priorMap.put("+",1);
        priorMap.put("-",1);
        priorMap.put("*",2);
        priorMap.put("/",2);
    }

    static int getIndexPriorOperation(List<String> operation){
        int index = -1;
        int currentPr = -1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if(priorMap.get(op)>currentPr){
                currentPr = priorMap.get(op);
                index = i;
            }
        }
        return index;
    }

    Var calc (String expression) throws CalcException{
        //A=((5+2)-4)/(1*1)
        List<String> str = null;

        if(expression.contains("(")) {
            str = new ArrayList<>(Arrays.asList(expression.split("(?<=\\G.{1})")));
        }

        while(expression.contains("(")) {
            int indexLastOpenBracket = 0;
            int indexFirstCloseBracket = 0;
            for (int i = 0; i < str.size(); i++) {
                if (str.get(i).equals("(")) {
                    indexLastOpenBracket = i;
                } else if (str.get(i).equals(")") && indexLastOpenBracket<i) {
                    indexFirstCloseBracket = i;
                    break;
                }
            }
            String subExpression="";
            for (int i = 0; i <= indexFirstCloseBracket - indexLastOpenBracket; i++) {
                if(i==0 || i == indexFirstCloseBracket - indexLastOpenBracket) {
                    str.remove(indexLastOpenBracket);
                }else{
                    subExpression += str.remove(indexLastOpenBracket);
                }
            }
            str.add(indexLastOpenBracket,calc(subExpression).toString());
            String newExpression="";
            for (int i = 0; i < str.size(); i++) {
                newExpression+=str.get(i);
            }
            expression=newExpression;
        }

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Operation.OPERATION)));
        List<String> operations = new ArrayList<>();
        Pattern patternOperation = Pattern.compile(Operation.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        while (matcherOperation.find()){
            operations.add(matcherOperation.group());
        }

        while (operations.size()>0){
            int index = getIndexPriorOperation(operations);
            String oneOperand = operands.remove(index);
            String twoOperand = operands.remove(index);
            String operation = operations.remove(index);
            String res = oneOperation(oneOperand, operation, twoOperand);
            operands.add(index,res);
        }

        return Var.createVar(operands.get(0));
    }

    private String oneOperation(String sOne, String operation, String sTwo) throws CalcException{
        Var two = Var.createVar(sTwo);

        if(operation.contains("=")){
            return  Var.saveVar(sOne,two).toString();
        }

        Var one = Var.createVar(sOne);

        if(one == null||two == null){
            Log.setLog("Пустой ввод");
            throw new CalcException("Пустой ввод");
        }

        switch (operation){
            case "+": return one.add(two).toString();
            case "-": return one.sub(two).toString();
            case "*": return one.mul(two).toString();
            case "/": return one.div(two).toString();
        }

        Log.setLog("Неправильный операнд");
        throw new CalcException("Неправильный операнд");
    }

}
