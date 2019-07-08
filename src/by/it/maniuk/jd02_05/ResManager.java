package by.it.maniuk.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String basename = "by.it.maniuk.jd02_05.resources.messages";
    private Locale locale;
    private ResourceBundle bundle;
    private DateFormat dateFormat;
    ResManager() {
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        Locale.setDefault(Locale.ENGLISH);

    }

    public void setLocale(String language, String country) {
        locale = new Locale(language, country);
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        bundle = ResourceBundle.getBundle(basename, locale);

    }

    public String get(String key) {
        return bundle.getString(key);
    }
    public String getTime(Date key) {
        return dateFormat.format(key);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        bundle = ResourceBundle.getBundle(basename, locale);

    }
}
