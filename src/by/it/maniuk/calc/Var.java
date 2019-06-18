package by.it.maniuk.calc;

import java.util.HashMap;
import java.util.Map;


abstract class Var implements Operation {

   private static Map<String, Var> vars = new HashMap<>();

      static Var saveVar(String name, Var var){
        vars.put(name, var);

        return  var;
   }

    static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String strVar) throws CalcException {
          strVar = strVar.replaceAll("\\s+", "");

        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (vars.containsKey(strVar))
            return vars.get(strVar);
      throw  new CalcException("ERROR: Не возможно создать " + strVar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw  new CalcException(("ERROR: Операция сложения "+this+ "+" + other + " невозможна"));

    }

    @Override
    public Var sub(Var other) throws CalcException {
       throw new CalcException ("ERROR: Операция вычитания  "+this+ "-" + other + " невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException {
       throw  new CalcException("ERROR: Операция умножения "+this+ "*" + other + " невозможна");

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw  new CalcException("ERROR: Операция деления "+this+ "/" + other + " невозможна");

    }

    @Override
  public String toString(){
      return "abstract var";
  }

}
