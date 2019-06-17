package by.it.dilkevich.jd01_10;

public class Bean {

    @Param(a = 34, b = 434)
    static double sum(int a, int b){

        double result = a + b;
        return result;
    }

    @Param(a = 3, b = 342)
    static double max(int a, int b){

        if(a > b){

            return (double) a;
        }

        else {

            return (double)b;
        }

    }

    @Param(a = 1, b = 55)
    double min(int a, int b){

        if (a < b){

            return (double)a;
        }

        else {

            return (double)b;
        }
    }

    double avg(int a, int b){

        double result = (a + b) / 2.0;
        return result;
    }
}
