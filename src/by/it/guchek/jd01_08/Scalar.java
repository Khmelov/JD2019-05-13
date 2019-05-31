package by.it.guchek.jd01_08;

class Scalar extends Var{                                    //убрала публичный т.к. больше нигде не будет виден
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {  //конструктор будет принимать какое то значение value и заносить это значение
                                   //во внутреннее поле  // тоже убрали публичный
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value+((Scalar) other).value;
            return new Scalar(sum);

    }else return other.add(this);
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
        double raz = this.value-((Scalar) other).value;
        return new Scalar(raz);

    }
        else return new Scalar(-1).mul(other).add(this); //3-{1,2,3} --> -1*{1,2,3}+5
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value*((Scalar) other).value;
            return new Scalar(mul);

        }else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double div = this.value/((Scalar) other).value;
            return new Scalar(div);

        }else return super.div(other);
    }

    Scalar (Scalar scalar){           //принимает на вход экземпляр этого класса
        this.value = scalar.value; // заполним поле value в this,  а берем это значение из класса scalar
    }

    Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar); //преобразует строковое значение к double
    }

    @Override
    public String toString() {
        return Double.toString(value);   //переопределили метод String toString, чтобы он печатал любое значение
    }
}
