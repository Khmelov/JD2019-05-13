package by.it.zhukova.calc;

import by.it.zhukova.calc.exceptions.Exceptions;
import java.util.*;
import static by.it.zhukova.calc.ConsoleRunner.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var createVar(String strVar) throws CalcException {
        String strVarClear = strVar.replaceAll("\\s+", "");
if (strVarClear.matches(Patterns.SCALAR)) return new Scalar(strVarClear);
    else    if (strVarClear.matches(Patterns.VECTOR)) return new Vector(strVarClear);
    else    if (strVarClear.matches(Patterns.MATRIX)) return new Matrix(strVarClear);
    else    if (vars.containsKey(strVarClear)) return vars.get(strVarClear);

        throw new CalcException(manager.get(Exceptions.VAR)+strVarClear);
           }

    static void save(String name, Var var) {
        vars.put(name, var);
    }

    static void printvar (){
        Set<Map.Entry<String, Var>> set = vars.entrySet();
        Iterator<Map.Entry<String, Var>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Var> next = iterator.next();
            System.out.println(next.getKey()+"="+next.getValue());
        }
    }
    static void sortvar () {
        Map<String,Var> sortV = new TreeMap <String,Var>(vars);
        System.out.println(sortV);
   }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Exceptions.OPERATION)
                +this+"+"+other+ manager.get(Exceptions.IMPOSSIBLE)));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Exceptions.OPERATION)
                +this+"-"+other+ manager.get(Exceptions.IMPOSSIBLE)));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Exceptions.OPERATION)
                +this+"*"+other+ manager.get(Exceptions.IMPOSSIBLE)));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(manager.get(Exceptions.OPERATION)
                +this+"/"+other+ manager.get(Exceptions.IMPOSSIBLE)));
    }
}
