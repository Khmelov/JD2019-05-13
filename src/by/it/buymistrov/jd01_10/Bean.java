package by.it.buymistrov.jd01_10;

class Bean {

    @Param(a=4, b=70)
    double sum(int one, int two){
        return one + two;
    }
    double max(int one, int two){
        return one > two ? one:two;
    }
    @Param(a=4, b=70)
    static double min(int one, int two){
        return one < two ?one:two;
    }
    @Param(a=4, b=70)
    static double avg(int one, int two){
        return (one + two)/2.0;
    }


}
