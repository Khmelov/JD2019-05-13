package by.it.livanovich.calc.Text;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Helper {
    INSTANCE;

    private Locale locale;
    private String basename="by.it.livanovich.calc.resources.errors";
    private ResourceBundle bundle;

    Helper (){

        setLocale(Locale.ENGLISH);
    }

    public void setLocale (Locale locale){
        this.locale=locale;
        bundle=ResourceBundle.getBundle(basename,locale);
    }

    public String getKey (String key){
        return bundle.getString(key);
    }
}
