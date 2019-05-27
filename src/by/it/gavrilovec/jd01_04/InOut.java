package by.it.gavrilovec.jd01_04;
class InOut {

    static double[ ] getArray(String line){
        String[] lineArray=line.trim().split("\\s+");
        double [] arr=new double[lineArray.length];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=Double.parseDouble(lineArray[i]);
        }
        return arr;
    }




    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i <arr.length; i++) {
            System.out.printf("%s["+"%d"+"]=%-10.1f",name,i,arr[i]);
            if(i%columnCount==3) System.out.println();
        }

    }
}