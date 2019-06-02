package by.it.yakimovich.jd01_08;

import java.util.Arrays;

public class Matrix extends Var{
    private double[][] value;

    public Matrix(double[][] value) {
     this.value = value;
        }
    public Matrix(Matrix matrix) {
            this.value = matrix.value;
        }

        Matrix(String strMatrix){
            strMatrix=strMatrix.replace("{","");
            strMatrix=strMatrix.replace("},"," ");
            strMatrix=strMatrix.replace("}","");
            String[] stre=strMatrix.split(" ");
            double[][] strM=new double[stre.length][stre[0].length()/2];
            for (int i = 0; i <stre.length ; i++) {
                String[]  elemString=stre[i].split(",");
                double[] elemDouble= new double[elemString.length];
                for (int j = 0; j < elemDouble.length; j++) {
                    elemDouble[j] = Double.parseDouble(elemString[j]);
                }
                strM[i]= Arrays.copyOf(elemDouble,elemDouble.length);
            }
            this.value= strM;
        }



        @Override
        public String toString() {

            StringBuilder sb=new StringBuilder("{{");
            String delimeter="";

            for (double[] element:value) {
                for (double em:element) {


                    sb.append(delimeter).append(em);
                    delimeter = ",";
                }
                delimeter = "},{";
            }

            sb.append("}}");
            return sb.toString();
        }

        @Override
        public Var add(Var other) {
            if (other instanceof Scalar) {
                double[][] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++)
                    for (int j = 0; j <res[i].length ; j++) {
                        res[i][j] = res[i][j] + ((Scalar) other).getValue();
                    }
                return new Matrix(res);

            } else if (other instanceof by.it.yakimovich.jd01_08.Matrix) {
                double[][] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++)
                    for (int j = 0; j <res[i].length ; j++) {
                        res[i][j] = res[i][j] + ((Matrix) other).value[i][j];}
                return new Matrix(res);
            }
            else return super.add(other);

        }

        @Override
        public Var sub(Var other) { if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                for (int j = 0; j <res[i].length ; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            return new Matrix(res);

        } else if (other instanceof by.it.yakimovich.jd01_08.Matrix) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                for (int j = 0; j <res[i].length ; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];}
            return new Matrix(res);
        }
        else
            return super.sub(other);
        }

        @Override
        public Var mul(Var other) {
            if (other instanceof Scalar) {
                double[][] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++)
                    for (int j = 0; j <res[i].length ; j++) {
                        res[i][j] = res[i][j]* ((Scalar) other).getValue();}
                                    return new Matrix(res);

            }  else if (other instanceof Matrix) {
                double[][] res = Arrays.copyOf(this.value, value.length);
                int col = res[0].length;
                int newMatrixRow = res.length;
                int newMatrixCol =((Matrix) other).value [0].length;
                double[][] mResult = new double[newMatrixRow][newMatrixCol];
                for(int i = 0; i < newMatrixRow; i++) {
                    for(int j = 0; j < newMatrixCol; j++) {
                        for(int k = 0; k < col; k++) {
                            mResult[i][j] += res[i][k] *((Matrix) other).value [k][j];
                        }
                    }
                }
                                       return new Matrix(mResult);

                    }return super.mul(other);}}

