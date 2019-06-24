package by.it.lasotskaya.calc;


import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    Vector(double[] value){
        this.value= value;
    }

    Vector(Vector v){
        this.value=v.value;
    }

    Vector (String strVector){
        String[] strValues = strVector.replaceAll("[{}]", "").split(",");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[] res = Arrays.copyOf(value, value.length);
        if (other instanceof Scalar){
            for (int i = 0; i < res.length; i++) {
                res[i]= res[i] + ((Scalar)other).getValue();

            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (this.value.length < ((Vector) other).value.length
                    || ((Vector) other).value.length < this.value.length) {
                throw new CalcException(" Сложение векторов разной длинны невозможно ");
            } else
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];

                }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double [] res = Arrays.copyOf(value,value.length);
        if (other instanceof Scalar){
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] - ((Scalar)other).getValue();

            }
            return new Vector(res);

        }
        else if (other instanceof Vector){
            if (this.value.length < ((Vector) other).value.length
                    || ((Vector) other).value.length < this.value.length) {
                throw new CalcException(" Вычитание векторов разной длинны невозможно ");
            } else
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] - ((Vector)other).value[i];

            }
            return new Vector(res);


        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] * ((Scalar)other).getValue();

            }
            return new Vector(res);

        }
        else if (other instanceof Vector && this.value.length == ((Vector) other).value.length){
            double [] res = Arrays.copyOf(value,value.length);
            double sum=0;
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] * ((Vector)other).value[i];
                sum=sum +res[i];

            }
            return new Vector(res);
        }
        else throw new CalcException(" Операция невозможна ");
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0)
                throw new CalcException("Деление на ноль");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();

            }
            return new Vector(res);
        }
        if (other instanceof Vector){
            throw new CalcException("Нельзя делить на вектор");
        }
        else throw new CalcException(" Операция невозможна ");
    }

        @Override
    public String toString() {
       StringBuilder stringBuilder=new StringBuilder("{");
       String delimeter ="";
       //double mas[] = new double[0];
        for (double element : value) {
            stringBuilder.append(delimeter).append(element);
            delimeter = ", ";
    }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }



}
