package by.it.tbabich.calc;

import by.it.tbabich.calc.builder.FooterReport;
import by.it.tbabich.calc.builder.FullReportBuilder;
import by.it.tbabich.calc.builder.HeadReport;
import by.it.tbabich.calc.builder.ShortReportBuilder;
import by.it.tbabich.calc.names.ConsoleCommands;
import by.it.tbabich.calc.names.Countries;
import by.it.tbabich.calc.names.Languages;
import by.it.tbabich.calc.names.Messages;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


class Settings {

    static final ResManager manager = ResManager.INSTANCE;
    private static Logger logger;
    public static ShortReportBuilder shortReportBuilder;
    public static FullReportBuilder fullReportBuilder;

    public void initSetting(String[] args) {
        shortReportBuilder = new ShortReportBuilder();
        fullReportBuilder = new FullReportBuilder();
        shortReportBuilder.setStringBuilder(new StringBuilder(""));
        fullReportBuilder.setStringBuilder(new StringBuilder(""));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        shortReportBuilder.setHeadReport(new HeadReport("short"));
        shortReportBuilder.setFile(ZonedDateTime.now().format(formatter) + "_short.txt");
        fullReportBuilder.setHeadReport(new HeadReport("full"));
        fullReportBuilder.setFile(ZonedDateTime.now().format(formatter) + "_full.txt");

        logger = Logger.getInstance();
        if (args.length == 2) {
            String lang = args[0];
            String country = args[1];
            Locale locale = new Locale(lang, country);
            manager.setLocale(locale);
        }
    }

    public void stop(){
        logger.closeLogger();
        shortReportBuilder.setFooterReport(new FooterReport());
        fullReportBuilder.setFooterReport(new FooterReport());
        shortReportBuilder.getShortReport().writeReport();
        fullReportBuilder.getFullReport().writeReport();
    }

    public static void log(String message) {
        logger.writeLog(message);
    }

    public static boolean isSetLanguage(String expression) {
        boolean isSetLanguage = false;
        switch (expression) {
            case ConsoleCommands.SET_LANGUAGE_RU:
                Settings.manager.setLocale(new Locale(Languages.RU, Countries.RU));
                isSetLanguage = true;
                System.out.println(manager.get(Messages.SET_LANGUAGE));
                break;
            case ConsoleCommands.SET_LANGUAGE_EN:
                Settings.manager.setLocale(new Locale(Languages.EN, Countries.EN));
                isSetLanguage = true;
                System.out.println(manager.get(Messages.SET_LANGUAGE));
                break;
            case ConsoleCommands.SET_LANGUAGE_BE:
                Settings.manager.setLocale(new Locale(Languages.BE, Countries.BY));
                isSetLanguage = true;
                System.out.println(manager.get(Messages.SET_LANGUAGE));
                break;
        }
        return isSetLanguage;
    }
}
