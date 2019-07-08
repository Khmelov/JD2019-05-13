package by.it.yaskevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourcesManager {
    INSTANCE;

    private String baseName = "by.it.yaskevich.jd02_05.resources.messages";
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
