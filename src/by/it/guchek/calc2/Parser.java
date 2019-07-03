package by.it.guchek.calc2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {                //Принимает на вход некоторое выражение и в соответствие с ним
   Var calc(String expression) throws CalcException {                   //в своем внутреннем методе calc должен вычислить значение готовой переменной

      //2.0*2.0
      expression=expression.replaceAll("\\s", "");
      String [] operand = expression.split(Patterns.OPERATION);
      //A=9
      Var two = Var.createVar(operand[1]);
      if(expression.contains("=")){
         return Var.saveVar(operand[0], two);
      }
      Var one = Var.createVar(operand[0]);
      if ( one==null || two==null )  //TODO create error
      {
         throw new CalcException("Пустая переменная");
      }
      Pattern p = Pattern.compile(Patterns.OPERATION);
      Matcher m = p.matcher(expression);      //выщимливаем знаки
      if (m.find()){
         String operation = m.group();
         switch (operation){
            case "+": return one.add(two);
            case "-": return one.sub(two);
            case "*": return one.mul(two);
            case "/": return one.div(two);
            //case "=": return Var.saveVar(operand[0], two);
         }
      }

      throw new CalcException("Ошибка парсинга выражений");

   }
}