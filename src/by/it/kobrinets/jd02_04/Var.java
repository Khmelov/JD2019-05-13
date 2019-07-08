package by.it.kobrinets.jd02_04;

import java.util.*;

abstract class Var implements Operation {
    static Map<String, Var> vars = new HashMap<>();
    private static Vars factory = new Vars();

    static Var saveVar(String nameVar, Var valueVar) {
        vars.put(nameVar, valueVar);
        return valueVar;
    }

    static Set<Map.Entry<String, Var>> printVar() {
        Set<Map.Entry<String, Var>> setVar = vars.entrySet();
        System.out.println(setVar);
        Iterator<Map.Entry<String, Var>> iteratorI = setVar.iterator();

        while (iteratorI.hasNext()) {
            Map.Entry<String, Var> values = iteratorI.next();
            System.out.println(values.getKey() + "=" + values.getValue());
        }
        return setVar;
    }

    static void sortVar() {
        Map<String, Var> sorted = new TreeMap<>(vars);
        System.out.println(sorted);
    }

    static Var createVar(String strVar) throws CalcException {
        return factory.getVar(strVar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + " + "+ other + "невоможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + " - " + other + "невоможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * "+ other + "невоможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / "+ other + "невоможна");
    }

    @Override
    public String toString() {
        return "Abstract class";
    }
}

