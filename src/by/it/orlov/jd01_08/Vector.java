package by.it.orlov.jd01_08;


import java.util.Arrays;

class Vector extends Var {

    private double[] v1;


    public Vector(double[] v1){
        this.v1 = v1;
    }

    public Vector(Vector vector){
        this.v1 = vector.v1;
    }

    public Vector(String strVector){
        String[] strM = strVector.replaceAll("[{}]", "").split(",");
        double[] vec = new double[strM.length];
        for (int i = 0; i < strM.length; i++) {
            vec[i] = Double.parseDouble(strM[i]);
        }
        this.v1 = vec;
    }


    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double s= ((Scalar) other).getValue();
            double[] res=Arrays.copyOf(v1, v1.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=s;
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] v= ((Vector) other).v1;
            double[] res=Arrays.copyOf(v1, v1.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=v[i];
            }
            return new Vector(res);
        }else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double s= ((Scalar) other).getValue();
            double[] res=Arrays.copyOf(v1, v1.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=s;
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] v= ((Vector) other).v1;
            double[] res=Arrays.copyOf(v1, v1.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=v[i];
            }
            return new Vector(res);
        }else {
            return super.add(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double s= ((Scalar) other).getValue();
            double[] res= new double[v1.length];
            for (int i = 0; i < v1.length; i++) {
                res[i]+=s*v1[i];
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] v= ((Vector) other).v1;
            double[] res=Arrays.copyOf(v1, v1.length);
            double result = 0;
            for (int i = 0; i < res.length; i++) {
                result+=res[i]*v[i];
            }
            return new Scalar(result);
        }else {
            return super.add(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = new double[v1.length];
            for (int i = 0; i < v1.length; i++) {
                res[i] += v1[i] / s;
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = 0; i < v1.length; i++) {
            if(i==v1.length-1){
                str.append(v1[i]+"}");
            }else{str.append(v1[i]+", ");}
        }
        return str.toString();
    }
}
