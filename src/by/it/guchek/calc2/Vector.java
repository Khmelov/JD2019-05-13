package by.it.guchek.calc2;

import by.it.guchek.jd02_05.names.CalcErrors;

import java.util.Arrays;

import static by.it.guchek.calc2.ConsoleRunner.managerC;

class Vector extends Var {

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
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] sumArr=Arrays.copyOf(value, value.length);
            for (int i = 0; i <value.length ; i++) {
                sumArr[i]=sumArr[i]+((Scalar) other).getValue();
            }
            return new Vector(sumArr);
        }
        else if (other instanceof Vector){
            double [] sumArr=Arrays.copyOf(value, value.length);
            if (sumArr.length!=((Vector) other).value.length)
                throw new CalcException(managerC.get(CalcErrors.VECTORS_NOT_EQUAL));
            for (int i = 0; i <value.length ; i++) {
                sumArr[i]=sumArr[i]+((Vector) other).value[i];
            }
            return new Vector(sumArr);
        }
            return super.add(other);
        }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Vector) {
            double[] razArr = Arrays.copyOf(value, value.length);
            if (razArr.length!=((Vector) other).value.length)
                throw new CalcException(managerC.get(CalcErrors.VECTORS_NOT_EQUAL));
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
    public Var mul(Var other) throws CalcException {
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
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0)
                throw new CalcException(managerC.get(CalcErrors.DIVNULL));
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
