package by.it.dnevar.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String basename = "by.it.dnevar.jd02_05.resources.messages";
    private Locale locale;
    private ResourceBundle bundle;
    private DateFormat df;

    ResManager() {
        setLocale(Locale.ENGLISH);
        df = DateFormat.getDateInstance(DateFormat.DEFAULT,Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle(basename, locale);
        df = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }

    public String getTime(Date date){
        return df.format(date);
    }

}
