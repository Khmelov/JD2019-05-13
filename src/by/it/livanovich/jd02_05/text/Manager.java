package by.it.livanovich.jd02_05.text;


import java.util.Locale;
import java.util.ResourceBundle;

public enum  Manager {
    INSTANCE;

    private String basename="by.it.livanovich.jd02_05.resources.messages";

    public Locale getLocale() {
        return locale;
    }

    private Locale  locale;
    private ResourceBundle bundle;

    Manager() {
        Locale.setDefault(Locale.ENGLISH);
        setLocale(Locale.ENGLISH);
    }

    public void setLocale (Locale locale){
        this.locale=locale;
        bundle=ResourceBundle.getBundle(basename,locale);
    }

    public String get (String key){
        return bundle.getString(key);
    }
}
