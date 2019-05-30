package by.it.dnevar.jd01_08;

class Matrix extends Var{
    private double[][] value;

    Matrix(double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        String str = strMatrix.substring(2,strMatrix.length()-2);
        String[] split1 = str.split("},\\{");
        String [][] split2 = new String[split1.length][];
        for (int i = 0; i < split1.length; i++) {
            split2[i] = split1[i].split(",");
        }
        value = new double[split1.length][split2[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j]=Double.parseDouble(split2[i][j]);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("{{");
        String arrDelimiter = "},{";
        for (int i = 0; i < value.length; i++) {
            String numDelimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                str.append(numDelimiter).append(value[i][j]);
                numDelimiter = ", ";
            }
            if (i !=value.length-1) {
                str.append(arrDelimiter);
            }
        }
        str.append("}}");
        return str.toString();
    }
}
