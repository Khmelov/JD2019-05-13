package by.it.dnevar.jd01_08;

class Vector extends Var{

    private double[] value;

    Vector (double[] value){
        this.value = value;
    }

    Vector (Vector vector){
        this.value = vector.value;
    }

    Vector (String strVector){
        String str = strVector.substring(1,strVector.length()-1);
        String[] arrStr = str.split(",");
        value = new double[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            value[i] = Double.parseDouble(arrStr[i]);
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("{");
        String delimiter = "";
        for (double element: value){
            str.append(delimiter).append(element);
            delimiter = ", ";
        }
        str.append("}");
        return str.toString();
    }
}
