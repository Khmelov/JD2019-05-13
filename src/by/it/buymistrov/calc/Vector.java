package by.it.buymistrov.calc;


import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;

    }

    Vector(Vector vector) {
        this.value = vector.value;

    }

    Vector(String strValue) {

        String[] str = strValue
                .replaceAll("[{},]", " ")
                .trim()
                .replaceAll("[ ]+", "%")
                .split("%");


        double[] strArray = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            strArray[i] = Double.parseDouble(str[i]);
        }
        this.value = strArray;


    }

    @Override
    public Var add(Var other) {

        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += s;
            }
            return new Vector(result);
        } else if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double[] v = ((Vector) other).value;

            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += v[i];

            }
            return new Vector(result);

        } else

            return super.add(other);

    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= s;
            }
            return new Vector(result);
        } else if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double[] v = ((Vector) other).value;

            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= v[i];

            }
            return new Vector(result);

        } else

            return super.sub(other);

    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= s;
            }
            return new Vector(result);
        } else if (other instanceof Vector && value.length == ((Vector) other).value.length) {
            double[] v = ((Vector) other).value;
            double resScalar = 0;
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                resScalar = resScalar + (result[i] * v[i]);

            }
            return new Scalar(resScalar);

        } else

            return super.mul(other);


    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= s;
            }
            return new Vector(result);
        } else

            return super.div(other);



    }

        @Override


        public String toString () {
            String out = Arrays.toString(value)
                    .replaceAll("\\[", "{")
                    .replaceAll("\\]", "}");
            return out;
        }


    }
