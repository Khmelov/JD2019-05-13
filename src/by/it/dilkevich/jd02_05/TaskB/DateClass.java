package by.it.dilkevich.jd02_05.TaskB;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class DateClass {

    private DateFormat dateFormat;

    String getDateFormat() {
        return dateFormat.format(new Date());
    }

    void setDateLocale(String lang){

        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(lang));
    }
}
