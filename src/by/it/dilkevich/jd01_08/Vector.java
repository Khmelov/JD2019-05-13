package by.it.dilkevich.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double [] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[ ] value){
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector){
        this.value = vector.value;
    }

    public Vector(String strVector){
        String [] mas = strVector.split(",");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = mas[i].replace("{", "").replace("}", "");
        }
        double [] tempMas = new double[mas.length];

        for (int i = 0; i < mas.length; i++) {
            tempMas[i] = Double.parseDouble(mas[i]);
        }
        value = Arrays.copyOf(tempMas, mas.length);
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimeter = "";
        for (double x :
                this.value) {
            sb.append(delimeter).append(x);
            delimeter = ", ";
        }

        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double [] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if(other instanceof Vector){
            double [] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double [] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector){
            double [] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        }

        else if (other instanceof Vector){
            double [] result = Arrays.copyOf(value,value.length);
            double sum = 0;
            for (int i = 0; i < result.length; i++) {
                sum = sum + result[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);
        }
        else
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }
}
