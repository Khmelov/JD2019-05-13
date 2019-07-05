package by.it.tbabich.jd02_05;

import by.it.tbabich.jd02_05.names.Countries;
import by.it.tbabich.jd02_05.names.Languages;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {

    INSTANCE;

    private Locale locale;
    private ResourceBundle resourceBundle;
    private String basename = "by.it.tbabich.jd02_05.resources.messages";

    private ResManager() {
        setLocale(new Locale(Languages.EN, Countries.EN));
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(basename, locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

}
