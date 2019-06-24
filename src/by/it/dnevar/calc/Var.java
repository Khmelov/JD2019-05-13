package by.it.dnevar.calc;

import java.io.File;
import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    private static String varsTxt = getFilePath(Var.class,"vars.txt");

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }

    public static Var createVar(String operand) throws CalcException{
        operand = operand.trim().replaceAll("\\s+","");
        if(operand.matches(Operation.SCALAR)){
            return new Scalar(operand);
        }else if(operand.matches(Operation.VECTOR)){
            return new Vector(operand);
        }else if(operand.matches(Operation.MATRIX)){
            return new Matrix(operand);
        }else if(vars.containsKey(operand)) {
            return vars.get(operand);
        } else {
            throw new CalcException("Не возможно создать " + operand);
        }
    }

    public static void printVar() {
        for(Map.Entry<String, Var> entry: vars.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    public static void printSortVar() {
        Map<String, Var> sortVars = new TreeMap<>(vars);
        for(Map.Entry<String, Var> entry: vars.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция "+this+" + "+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException ("Операция "+this+" - "+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция "+this+" * "+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция "+this+" / "+other+" невозможна");
    }

    @Override
    public String toString(){
        return "Этот класс Var";
    }

    private static String getPath (Class<?> aClass){
        String root = System.getProperty("user.dir")
                + File.separator
                +"src"
                +File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+name;
    }

    private static String getFilePath(Class<?> aClass, String filename){
        return getPath(aClass)+filename;
    }

}
