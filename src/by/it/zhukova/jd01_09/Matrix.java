package by.it.zhukova.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
   private double [] [] value;

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
    public Var add(Var other) {
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
    public Var sub(Var other) {
        if (other instanceof Vector) {
            return super.sub(other);
        }
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
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
    public Var div(Var other) {
        return super.div(other);
    }

    Matrix(Matrix matrix) {
   this.value=matrix.value;
   }

    Matrix(String strMatrix) {
        Pattern p1 = Pattern.compile("\\p{Punct}+\\p{Blank}*\\p{Punct}+\\p{Blank}*\\p{Punct}+");
        Matcher m1 = p1.matcher(strMatrix);
        int posCol = 0;
        int k=0;
        while (m1.find()){
            if (posCol==0) {
                posCol=m1.start();
            }
            k++;
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
        double [ ][] matrixResult = new double[k+1][m];
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
