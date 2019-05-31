package by.it.guchek.jd01_08;

import java.util.Arrays;

class Vector extends Var  {

    private double [] value;

    //public double[] getValue() {
     //return value;
    //}

    Vector(double[] value) {
                                         //конструктор будет принимать какое то значение value и заносить это значение
        this.value = Arrays.copyOf(value,value.length);//во внутреннее поле

    }

                                            //void reset(){value[0]=0;}

    Vector(Vector vector){
        this.value = vector.value;
    }

    Vector(String strVector){
        String sVect=strVector.replaceAll("[{}\\s]","").trim();
        String[] str = sVect.split(",");
        //for (String s : str) {
        //    int i=0;
        //    str[i].trim();
        //    i++;
        //}

        double [] strArrDoub = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            strArrDoub[i] = Double.parseDouble(str[i]);
    }
        //value = strArrDoub;
        this.value=strArrDoub;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [] sumArr=Arrays.copyOf(value, value.length);
            for (int i = 0; i <value.length ; i++) {
                sumArr[i]=sumArr[i]+((Scalar) other).getValue();
            }
            return new Vector(sumArr);
        }
        else if (other instanceof Vector){
            double [] sumArr=Arrays.copyOf(value, value.length);
            for (int i = 0; i <value.length ; i++) {
                sumArr[i]=sumArr[i]+((Vector) other).value[i];
            }
            return new Vector(sumArr);
        }
            return super.add(other);
        }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            double[] razArr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                razArr[i] = razArr[i] - ((Vector) other).value[i];
            }

            return new Vector(razArr);

        } else if (other instanceof Scalar) {
            double[] razArr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                razArr[i] = razArr[i] - ((Scalar) other).getValue();}
                return new Vector(razArr);
            }
         return super.sub(other);
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
