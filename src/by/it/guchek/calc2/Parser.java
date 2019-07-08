package by.it.guchek.calc2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

   private static final Map<String, Integer> priorMap = new HashMap<>();

   static {
      priorMap.put("=", 0);
      priorMap.put("+", 1);
      priorMap.put("-", 1);
      priorMap.put("*", 2);
      priorMap.put("/", 2);
   }

   private int getIndex(List<String> operation) {
      int index = -1;
      int currentPr = -1;
      for (int i = 0; i < operation.size(); i++) {
         String op = operation.get(i);
         if (priorMap.get(op) > currentPr) {
            currentPr = priorMap.get(op);
            index = i;
         }
      }
      return index;
   }

   private String oneOperaion(String sOne, String operation, String sTwo) throws CalcException {
      Var two = Var.createVar(sTwo);
      if (operation.equals("=")) {
         String name = sOne;
         Var.saveVar(name, two);
         return two.toString();
      }

      Var one = Var.createVar(sOne);

      switch (operation) {
         case "+":
            return one.add(two).toString();
         case "-":
            return one.sub(two).toString();
         case "*":
            return one.mul(two).toString();
         case "/":
            return one.div(two).toString();
      }
      throw new CalcException("Error !!!!!");
   }

   Var calc2(String expression) throws CalcException {
      expression = expression.replaceAll("\\s+", "");
      List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
      List<String> operation = new ArrayList<>();
      Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
      Matcher matcherOperation = patternOperation.matcher(expression);
      while (matcherOperation.find()) {
         operation.add(matcherOperation.group());
      }

      while (operation.size() > 0) {
         int index = getIndex(operation);
         String sOne = operands.remove(index);
         String sTwo = operands.remove(index);
         String op = operation.remove(index);
         String result = oneOperaion(sOne, op, sTwo);
         operands.add(index, result);
      }
      return Var.createVar(operands.get(0));

   }

   Var calc (String expression) throws CalcException {  //clearExprFromBrace

      StringBuilder incomingExpression = new StringBuilder(expression);
      StringBuilder sbForExprFromBrace= new StringBuilder();
      Pattern patternExprInBrace = Pattern.compile(Patterns.BRACE);
      Matcher matcher = patternExprInBrace.matcher(incomingExpression);

      while (matcher.find()){
         sbForExprFromBrace.append(matcher.group());
         incomingExpression.replace(matcher.start()-1,matcher.end()+1,calc(sbForExprFromBrace.toString()).toString());
         sbForExprFromBrace.delete(0,sbForExprFromBrace.length());
         matcher.reset();}

      return calc2(incomingExpression.toString());
   }


}