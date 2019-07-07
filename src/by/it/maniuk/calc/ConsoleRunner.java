package by.it.maniuk.calc;

import by.it.maniuk.calc.names.Messages;
import by.it.maniuk.calc.names.User;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Date data = new Date();
        DocumentBuilder builderSimple =new SimpleBuilder();
        DocumentBuilder builderComplicated =  new ComplicatedBuilder();
        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
           String lang = args[0];
          String  country = args[1];
            builderSimple.createHeader();
            builderComplicated.createHeader();
            manager.setLocale(lang, country);
            lacal(manager, data);
        }

        try {
            Var.backToMap();
        } catch (CalcException | IOException e) {
            Singleton sing = Singleton.getInstance();
            sing.printErrorToLog(e);
            builderSimple.createParagraph(e.getMessage(), true);
            builderComplicated.createParagraph(e.getMessage(), true);
        }
        String s;
        while (! (s = scanner.nextLine()).equals("end")) {
            builderSimple.createParagraph(s,true);
            builderComplicated.createParagraph(s,true);
            if (s.equals("ru")){
                    manager.setLocale("ru", "RU");
                    lacal(manager,data);
                   }
            if (s.equals("be")) {
                manager.setLocale("be", "BY");
                lacal(manager,data);
                    }
            if (s.equals("en")) {
                    manager.setLocale(Locale.getDefault());
                lacal(manager,data);
            }
            if (s.equals("sortvar")) {
                Printer.sortVar();
                continue;
            }
            if (s.equals("printvar")) {
                Printer.printVar();
                continue;
            }
            Var result = null;
            try {
                result = parser.calc(s);
                if (result !=null){
                builderSimple.createParagraph(result.toString(),true);
                builderComplicated.createParagraph(result.toString(),true);
                }

            } catch (IOException | CalcException e) {
                Singleton sing = Singleton.getInstance();
                sing.printErrorToLog(e);
                builderSimple.createParagraph(e.getMessage(),true);
                builderComplicated.createParagraph(sing.returnError(e), true);
            }
            printer.print(result);
        }
        builderSimple.createBody();
        builderComplicated.createBody();
    }
     private static void lacal( ResManager manager, Date date) {
         Singleton sing = Singleton.getInstance();
         sing.printMessageToLog(manager.get(Messages.WELCOME));
         sing.printMessageToLog(manager.get(Messages.QUESTION));
         sing.printMessageToLog(manager.get(User.NAME));
         sing.printMessageToLog(ResManager.INSTANCE.getTime(date));
    }
}