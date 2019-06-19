package by.it.aadamovich.calc;


import java.util.HashMap;
import java.util.Map;

// container for Var add
class VarList {

    private static Map<String, Var> list;
    static {
        list = new HashMap<>();
    }

    static Var setVariable(String name, Var variable) {
        list.put(name, variable);
        return variable;
    }

    static Var getVariable (String name){
        return list.get(name);
    }

    static boolean containVariable (String name) {
        return list.containsKey(name);
    }

    static Map<String, Var> getList() {
        return list;
    }
}
