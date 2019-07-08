package by.it.yaskevich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourcesManager {
    INSTANCE;

    private String baseName = "by.it.yaskevich.calc.resources.messages";
    private Locale locale;
    ResourceBundle resourceBundle;

    ResourcesManager() {
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

    public Locale getLocale() {
        return resourceBundle.getLocale();
    }
}
