package by.it.guchek.jd01_07;

import java.util.Arrays;

class Vector extends Var  {

    private double [] value;

    Vector(double[] value) {
                                         //конструктор будет принимать какое то значение value и заносить это значение
        this.value = Arrays.copyOf(value,value.length);//во внутреннее поле

    }
    void reset(){
        value[0]=0;
    }

    Vector(Vector vector){
        this.value = vector.value;
    }

    Vector(String strVector){
        String sVect=strVector.replaceAll("[{},\\s]"," ").trim();
        String[] str = sVect.split("  ");
        //StringBuilder str = new StringBuilder(strVector);
        //str.delete(0,0).delete(4,4).delete(9,9).delete(14,14);
        //strVector=str.toString();
        double [] strArrDoub = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            strArrDoub[i] = Double.parseDouble(str[i]);
          //  this.value[i]=Double.parseDouble(str));
    }
        value = strArrDoub;
        this.value=value;
    }
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{");
        String delimetr = "";
        for (double element : value) {
            sb.append(delimetr).append(element);
            delimetr=", ";
            
        }
        sb.append("}");
        return sb.toString();
    }


}
