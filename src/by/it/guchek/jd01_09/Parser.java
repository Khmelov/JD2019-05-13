package by.it.guchek.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {                //Принимает на вход некоторое выражение и в соответствие с ним
   Var calc(String expression) {                   //в своем внутреннем методе calc должен вычислить значение готовой переменной

      //2.0*2.0
      String [] operand = expression.split(Patterns.OPERATION);
      Var one = Var.createVar(operand[0]);
      Var two = Var.createVar(operand[1]);
      if ( one==null || two==null )  //TODO create error
         return null;
      Pattern p = Pattern.compile(Patterns.OPERATION);
      Matcher m = p.matcher(expression);      //выщимливаем знаки
      if (m.find()){
         String operation = m.group();
         switch (operation){
            case "+": return one.add(two);
            case "-": return one.sub(two);
            case "*": return one.mul(two);
            case "/": return one.div(two);
         }
      }

      return null;

   }
}