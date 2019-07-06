package by.it.guchek.calc2;

import by.it.guchek.jd02_05.ResManager;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static ResManagerForCalc managerC = ResManagerForCalc.INSTANCE;

    public static void main(String[] args) {
        managerC.setLocale(Locale.getDefault());
        System.out.println(Locale.getDefault());
        Scanner sc = new Scanner(System.in);
        String line;
        //создаем экземпляры
        Printer printer = new Printer();
        Parser parser = new Parser();

        while (!(line = sc.nextLine()).equals("end")) {  //будем читать линии из консоли

             try {
                    if (line.equals("printvar")){
                        printer.printMap();
                    } else if (line.equals("sortvar")) printer.sortvar();
                        else if(line.equals("ru")){
                        Locale locale = new Locale("ru", "RU");
                        managerC.setLocale(locale);

                    }   else if(line.equals("be")){
                        Locale locale = new Locale("be", "BY");
                        managerC.setLocale(locale);
                        //System.out.println(managerC.getLocale());

                    }   else if(line.equals("en")){
                        Locale locale = new Locale("en", "EN");
                        managerC.setLocale(locale);
                    }
                            else {Var result = parser.calc(line);
                                  printer.print(result);
                            }
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    //e.printStackTrace();
                }
        }

    }
}
