package by.it.maniuk.calc;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;


class Printer {

    void print(Var result){
        if (result!=null)
            System.out.println(result);
    }
    static void printVar(){

        String res = Var.getVars().toString();
        System.out.println(res);


    }
    static void sortVar(){
        Map<String, Var> sort = Var.getVars();
        Set<Map.Entry<String, Var>> entrySet = sort.entrySet();
        Iterator<Map.Entry<String, Var>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Var> me = iterator.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }

    }
}
