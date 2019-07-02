package by.it.dnevar.calc;

import java.io.*;
import java.util.*;

abstract class Var implements Operation {

    private static HashMap<String, Var> vars = new HashMap<>();

    private static String varsTxt = getFilePath(Var.class,"vars.txt");

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        try (PrintWriter out = new PrintWriter(new FileWriter(varsTxt))){
            Iterator<Map.Entry<String, Var>> iterator = vars.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry pair = iterator.next();
                out.println(pair.getKey()+"="+pair.getValue());
            }
        } catch (IOException e) {
            Log.setLog("Ошибка работы метода saveVar");
            e.printStackTrace();
        }
        return var;
    }

    static void varInTxt() throws CalcException{
        try(BufferedReader br = new BufferedReader(new FileReader(varsTxt))){
            String line;
            for(;br.ready();){
                line = br.readLine();
                if(line.equals("")) {
                    break;
                }
                String[] nameAndVar = line.split("=");
                String name = nameAndVar[0];
                Var var = createVar(nameAndVar[1]);
                vars.put(name, var);
            }
        } catch (FileNotFoundException e) {
            Log.setLog("Ошибка доступа к файлу");
            e.printStackTrace();
        } catch (IOException e) {
            Log.setLog("Ошибка в работе метода varInTxt");
            e.printStackTrace();
        }
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
            Log.setLog("Не возможно создать " + operand);
            throw new CalcException("Не возможно создать " + operand);
        }
    }

    public static void printVar() {
        for(Map.Entry<String, Var> entry: vars.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        Log.setLog("Переменные распечатаны по printvar");
    }

    public static void printSortVar() {
        Map<String, Var> sortVars = new TreeMap<>(vars);
        for(Map.Entry<String, Var> entry: vars.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        Log.setLog("Переменные отсортированы распечатаны по sortvar");
    }

    @Override
    public Var add(Var other) throws CalcException{
        Log.setLog("Операция "+this+" + "+other+" невозможна");
        throw new CalcException("Операция "+this+" + "+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        Log.setLog("Операция "+this+" - "+other+" невозможна");
        throw new CalcException ("Операция "+this+" - "+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        Log.setLog("Операция "+this+" * "+other+" невозможна");
        throw new CalcException("Операция "+this+" * "+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        Log.setLog("Операция "+this+" / "+other+" невозможна");
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
