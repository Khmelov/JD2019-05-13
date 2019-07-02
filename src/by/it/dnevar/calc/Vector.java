package by.it.dnevar.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector (double[] value){
        this.value = value;
    }

    Vector (Vector vector){
        this.value = vector.value;
    }

    Vector (String strVector){
        String str = strVector.substring(1,strVector.length()-1);
        String[] arrStr = str.split(",");
        value = new double[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            value[i] = Double.parseDouble(arrStr[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]+((Scalar)other).getValue();
            }
            Log.setLog(Arrays.toString(value)+"+"+((Scalar)other).getValue()+"="+Arrays.toString(res));
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                if(res.length==((Vector)other).value.length){
                    res[i] = res[i] + ((Vector) other).value[i];
                }else{
                    Log.setLog("Векторы разной длинны");
                    throw new CalcException("Векторы разной длинны");
                }
            }
            Log.setLog(Arrays.toString(value)+"+"+Arrays.toString(((Vector)other).value)+"="+Arrays.toString(res));
            return new Vector(res);
        }else{
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]-((Scalar)other).getValue();
            }
            Log.setLog(Arrays.toString(value)+"-"+((Scalar)other).getValue()+"="+Arrays.toString(res));
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                if(res.length==((Vector)other).value.length){
                    res[i] = res[i] - ((Vector) other).value[i];
                }else{
                    Log.setLog("Векторы разной длинны");
                    throw new CalcException("Векторы разной длинны");
                }
            }
            Log.setLog(Arrays.toString(value)+"-"+Arrays.toString(((Vector)other).value)+"="+Arrays.toString(res));
            return new Vector(res);
        }else{
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]*((Scalar)other).getValue();
            }
            Log.setLog(Arrays.toString(value)+"*"+((Scalar)other).getValue()+"="+Arrays.toString(res));
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            double result = 0;
            for (int i = 0; i < res.length; i++) {
                if(res.length==((Vector)other).value.length){
                    res[i] = res[i] * ((Vector)other).value[i];
                    result+=res[i];
                }else{
                    Log.setLog("Векторы разной длинны");
                    throw new CalcException("Векторы разной длинны");
                }
            }
            Log.setLog(Arrays.toString(value)+"*"+Arrays.toString(((Vector)other).value)+"="+result);
            return new Scalar(result);
        }else{
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                if(((Scalar) other).getValue()!=0) {
                    res[i] = res[i] / ((Scalar) other).getValue();
                }else{
                    Log.setLog("Деление на ноль");
                    throw new CalcException("Деление на ноль");
                }
            }
            Log.setLog(Arrays.toString(value)+"/"+((Scalar)other).getValue()+"="+Arrays.toString(res));
            return new Vector(res);
        } else{
            return super.div(other);
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("{");
        String delimiter = "";
        for (double element: value){
            str.append(delimiter).append(element);
            delimiter = ", ";
        }
        str.append("}");
        return str.toString();
    }
}
