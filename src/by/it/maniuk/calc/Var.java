package by.it.maniuk.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


abstract class Var implements Operation {

   private static Map<String, Var> vars = new HashMap<>();


    static Var saveVar(String name, Var var) throws IOException {
        vars.put(name, var);
        String path = getFilePath(Var.class, "vars.txt"); // TODO Надо не забыть вынести все про IO в отельный класс
        try(PrintWriter out = new PrintWriter( new FileWriter(path))) {
                out.println(name+"="+var);
                out.println();

        } catch (IOException e) {
            throw e;
        }
        return  var;
   }
   static void backToMap() throws CalcException {
       String path = getFilePath(Var.class, "vars.txt");
       try(BufferedReader in = new BufferedReader(new FileReader(path))) {
           int count =0;
           for (; ; ) {
               String line = in.readLine();
               count++;
               if (line == null)
                   break;
               else if (count==1) System.out.println("В памяти хранятся следующие переменные:");
               String[] lines = line.split("=");
               String name = lines[0];
               Var var = Var.createVar(lines[1]);
               vars.put(name,var);

               System.out.println(line);
           }

       } catch (IOException e) {
           e.printStackTrace();
       }
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

    private static String getFilePath(Class<Var> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<Var> aClass) {
        String root = System.getProperty("user.dir");
        String name = Var.class.getName();
        String simpleName = Var.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }

}
