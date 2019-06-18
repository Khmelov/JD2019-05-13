package by.it.maniuk.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {

        Pattern p = Pattern.compile(Patterns.OPERATION);
         Matcher m =p.matcher(expression);

        if (m.find()){
            String[] operand = expression.split(Patterns.OPERATION);
            Var two = Var.createVar(operand[1]);
            String operation = m.group();
            if (expression.contains("=") ){
                return Var.saveVar(operand[0], two);
            }

            Var one = Var.createVar(operand[0]);
            if (one==null || two == null){
                throw  new CalcException("ERROR: Вы ничего не ввели");} //TODO create error;
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }

        }
        throw new CalcException("ERROR: Ошибка парсинга");
      // throw new CalcException("ERROR: Не введена операция над ");
    }
}
