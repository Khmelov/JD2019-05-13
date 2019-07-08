package by.it.tbabich.calc;

import by.it.tbabich.calc.names.Countries;
import by.it.tbabich.calc.names.Languages;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {

    INSTANCE;

    private Locale locale;
    private ResourceBundle resourceBundle;
    private String basename = "by.it.tbabich.calc.resources.messages";

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
