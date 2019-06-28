package by.it.maniuk.calc;





import java.util.Arrays;

public class Vector extends Var{

    private double[] value;


    Vector(double[] value) {
        value = Arrays.copyOf(value, value.length);
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {

        String[] array = strVector.replace("{", "")
                                .replace("}", "")
                                .split(",");
        value = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            value[i]=Double.parseDouble(array[i]); //Здесь ошибка!!!!!!!!!
        }

   }


    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {

        if (other instanceof Scalar){
            double[] res =Arrays.copyOf(value, value.length) ;
            for (int i = 0; i < res.length; i++) {
               res[i] = res[i]+((Scalar) other).getValue();
            }

            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value, value.length);
            if (res.length !=((Vector) other).getValue().length){
                throw new CalcException("ERROR: Разная размерность векторов");
            }
            for (int i = 0; i <res.length ; i++) {
                res[i] = res[i]+((Vector) other).value[i];
            }

            return new Vector(res);

        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (res.length !=((Vector) other).getValue().length){
                throw new CalcException("ERROR: Разная размерность векторов");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }

            return new Vector(res);
        }
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value, value.length);
            double s = 0;
            for ( int i = 0; i < res.length; i++ ) {
                s += res[i] * ((Vector) other).value[i];
            }

            return new Scalar(s);
        }


        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }


        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("{");
        String delimeter = " ";
       for (int i = 0; i < value.length; i++) {
          double element = value[i];
           if (i==value.length-1)  b.append(element);
           else  b.append(element).append(",").append(delimeter);
       }
            b.append("}");
       return b.toString();
        }

    }


