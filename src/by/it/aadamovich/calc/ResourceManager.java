package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.Path;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;

    private ResourceBundle res;
    private Locale locale;
    private DateFormat df;

    ResourceManager() {
        setLocale(Locale.getDefault());
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    void setLocale(Locale locale) {
        this.locale = locale;
        res = ResourceBundle.getBundle(Path.RES_BASENAME, locale);
        df = DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    void setLocale(String language, String country) {
        setLocale(locale = createLocale(language, country));
    }

    Locale createLocale(String language, String country) {
        return new Locale(language, country);
    }

    Locale getLocale() {
        return locale;
    }

    String getString(String key) {
        return res.getString(key);
    }

    public String getDate() {
        Date date = new Date();
        return String.format(("%s %tT"), df.format(date), date);
    }
}
