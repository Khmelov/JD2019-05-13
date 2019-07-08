package by.it.orlov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class DateClass {

    private DateFormat dateFormat;

    void setdatelocale(String lang){

        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(lang));
    }
    String dateFormat() {
        return dateFormat.format(new Date());
    }


}
