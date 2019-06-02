package by.it.guchek.jd01_08;

import java.util.Arrays;

class Vector extends Var  {

    private double [] value;

    public double[] getValue() { return value; }



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
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double mulAll=0;
            double[] mulArr = Arrays.copyOf(value, value.length);
            double[] mulVal = new double[1];
            for (int i = 0; i < value.length; i++) mulVal[0]+= mulArr[i] * ((Vector) other).value[i];

            return new Vector(mulVal);}

        else if (other instanceof Scalar) {
            double[] mulArr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) mulArr[i] = mulArr[i] * ((Scalar) other).getValue();
            return new Vector(mulArr);
        }
        return super.mul(other);
    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] divArr = Arrays.copyOf(value, value.length);
                        for (int i = 0; i < value.length; i++) divArr[i] = divArr[i] / ((Scalar) other).getValue();
            return new Vector(divArr);
        }
        return super.div(other);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("");
        if (value.length==1) {sb.append(value[0]); return sb.toString();}
        else{String delimetr = "";
        sb.append("{");
        for (double element : value) {
            sb.append(delimetr).append(element);
            delimetr=", ";
        }
        sb.append("}");
        return sb.toString();}
    }


}
