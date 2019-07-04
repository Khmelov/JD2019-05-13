package by.it.yaskevich.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(
                ResourcesManager.INSTANCE.getString(Resources.THEADDITIONOPERATIONISNOTPOSSIBLE), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(
                ResourcesManager.INSTANCE.getString(Resources.THESUBTRACTIONOPERATIONISNOTPOSSIBLE), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(
                ResourcesManager.INSTANCE.getString(Resources.THEMULTIPLYOPERATIONISNOTPOSSIBLE), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(
                ResourcesManager.INSTANCE.getString(Resources.THEDIVISIONOPERATIONISNOTPOSSIBLE), this, other));
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+", "");

        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        else
            throw new CalcException(
                    ResourcesManager.INSTANCE.getString(Resources.UNABLETOCREATE) + " " + strVar);
    }

    static void printVar() {
        if (!vars.isEmpty()) {
            for (Map.Entry<String, Var> varEntry : vars.entrySet()) {
                System.out.printf("%s=%s\n", varEntry.getKey(), varEntry.getValue());
            }
        }
    }

    static void save(String s, Var two) {
        vars.put(s, two);
    }

    static void sortVar() {
        if (!vars.isEmpty()) {
            Map<String, Var> dictionary = new TreeMap<>(vars);
            for (Map.Entry<String, Var> varEntry : dictionary.entrySet()) {
                System.out.printf("%s=%s\n", varEntry.getKey(), varEntry.getValue());
            }
        }
    }

    static void saveVariables() {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(getFilePath(Var.class, "vars.txt")))) {
            for (Map.Entry<String, Var> var : vars.entrySet()) {
                out.printf("%s=%s\n", var.getKey(), var.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadVariables() {
        File file = new File(getFilePath(Var.class, "vars.txt"));
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {
            String rawData;
            while ((rawData = br.readLine()) != null) {
                if (rawData.isEmpty()) {
                    continue;
                }
                String[] strings = rawData.split("=");
                if (strings.length == 2) {
                    vars.put(strings[0], createVar(strings[1]));
                }
            }
        } catch (IOException | CalcException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + name;
    }

    private static String getFilePath(Class<?> aClass, String filename) {
        return getPath(aClass) + filename;
    }

}
