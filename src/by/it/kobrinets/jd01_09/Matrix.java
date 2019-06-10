package by.it.kobrinets.jd01_09;

public class Matrix extends Var {
    private double[][] value;
    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value=matrix.value;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter1 = "},{";
        for (int i = 0; i < value.length; i++) {
            String delimeitr2 = "";
            for (int j = 0; j < value[i].length; j++) {
            sb.append(delimeitr2).append(value[i][j]);
            delimeitr2 = ", ";
        }
            if (i !=value.length-1){
                sb.append(delimiter1);
            }
        }
        sb.append("}}");
        return sb.toString();
    }
}