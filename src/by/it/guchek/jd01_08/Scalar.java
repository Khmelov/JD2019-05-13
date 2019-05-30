package by.it.guchek.jd01_08;

class Scalar extends Var{                                    //убрала публичный т.к. больше нигде не будет виден
    private double value;


    Scalar(double value) {  //конструктор будет принимать какое то значение value и заносить это значение
                                   //во внутреннее поле  // тоже убрали публичный
        this.value = value;
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
