package by.it.zhukova.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
   private double [] [] value;
    public double[][] getValue() {
        return value;
    }

    Matrix(double[ ][ ]  value) {
      double  [][] row= new double[value.length][value[0].length];
       for (int i = 0; i < row.length; i++) {
           for (int j = 0; j < row[0].length; j++) {
           row [i] [j]= value[i][j];
       }
       }
   this.value= row;
   }

    @Override
    public Var add(Var other) throws CalcException {
            if (other instanceof Scalar){
                double  [][] add= new double[value.length][value[0].length];
                double s = ((Scalar) other).getValue();
                for (int i = 0; i < add.length; i++) {
                for (int j = 0; j < add[0].length; j++) {
                    add[i][j]= this.value[i][j]+s;
                }
            }
            return new Matrix(add);
        }
        else if (other instanceof Matrix){
                double  [][] add= new double[value.length][value[0].length];
                Matrix m = (Matrix) other;
                if (this.value.length != m.value.length | this.value[0].length != m.value[0].length )
                    throw new CalcException(" матрицы разных размеров");
                for (int i = 0; i < add.length; i++) {
                for (int j = 0; j < add[0].length; j++) {
                    add[i][j]= this.value[i][j]+ m.value[i][j];
                }
            }
            return new Matrix(add);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double  [][] sub= new double[value.length][value[0].length];
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[0].length; j++) {
                    sub[i][j]= this.value[i][j]-s;
                }
            }
            return new Matrix(sub);
        }
        else if (other instanceof Matrix){
            double  [][] sub= new double[value.length][value[0].length];
            Matrix m = (Matrix) other;
            if (this.value.length != m.value.length | this.value[0].length != m.value[0].length )
                throw new CalcException(" матрицы разных размеров");
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[0].length; j++) {
                    sub[i][j]= this.value[i][j]- m.value[i][j];
                }
            }
            return new Matrix(sub);
        }
        return super.sub(other);
    }
    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double  [][] mul= new double[value.length][value[0].length];
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    mul[i][j]=value[i][j]*s;
                }
            }
            return new Matrix(mul);
        }
        else if (other instanceof Vector){
            if (!(((Vector) other).getValue().length ==value[0].length))
                throw new CalcException(" число столбцов в матрице должно быть равно длине вектора");
            double[] mul = new double[value.length];
            double[] v = ((Vector) other).getValue();
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < v.length; j++) {
                    mul[i] = mul[i] + this.value[i][j] * v[j];
                }
            }
            return new Vector(mul);
        }
        else if (other instanceof Matrix){
            double[][] m = ((Matrix) other).value;
            double  [][] mul= new double[value.length][m[0].length];
            if (this.value[0].length != m.length)
                throw new CalcException(" число столбцов в первой матрице должно" +
                        " быть равно числу строк во второй матрице");
            for (int i = 0; i < this.value.length; i++) {
                for (int k = 0; k < m[0].length; k++) {
                    for (int j = 0; j < m.length; j++) {
                        mul[i][k] = mul[i][k] + this.value[i][j] * m[j][k];
                    }
                }
            }
            return new Matrix(mul);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    Matrix(Matrix matrix) {
   this.value=matrix.value;
   }

    Matrix(String strMatrix) {

        Pattern p1 = Pattern.compile("}");
        Matcher m1 = p1.matcher(strMatrix);
        int posCol = 0;
        int k=0;
        while (m1.find()){
            k++;
            if (posCol==0) {
                posCol=m1.start();
            }
        }
        Pattern p2 = Pattern.compile("-?\\d+\\.*\\d*");
        Matcher m2 = p2.matcher(strMatrix);
        int m=0;//счетчик столбцов по элементам
        while (m2.find()){

            if (posCol<m2.start()) {
                m2.reset();
                break;
            }
            m++;
        }
        double [ ][] matrixResult = new double[k-1][m];
        int i=0;
        int j=0;
        while (m2.find()){
            matrixResult[i][j]=Double.parseDouble(m2.group());
            j++;
            if (j==m) {
                i++;
                j = 0;
            }
        }
       this.value= matrixResult;
   }

   @Override
   public String toString() {
       StringBuilder out = new StringBuilder("{");

      for (int i = 0; i < value.length; i++) {
          String delimiter = "";
           out.append("{");
           for (int j = 0; j < value[0].length; j++) {
           out.append(delimiter).append(value[i][j]);
               delimiter = ", ";
           }
           out.append("}");
          if (i<value.length-1) out.append(", ");
       }
        out.append("}");
   return out.toString();
   }
}
