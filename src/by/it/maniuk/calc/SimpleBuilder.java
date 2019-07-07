package by.it.maniuk.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleBuilder extends DocumentBuilder {
    private Date date;
    private SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");

    SimpleBuilder() {
        date = new Date();
    }

    @Override
    public void createHeader() {

        createParagraph(ResManager.INSTANCE.getTime(date)+ " " + sdf.format(date),false);
    }

    @Override
    public void createParagraph(String parText, Boolean flag) {
        String path = getFilePath(SimpleBuilder.class, "reportShort.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(path, flag))) {
              out.print(parText);
//            out.print(Var.getVars());
            out.println();
        } catch (IOException e) {
            Singleton sing = Singleton.getInstance();
            sing.printErrorToLog(e);
        }
    }

    @Override
    public void createBody() {
        createParagraph(Var.getVars().toString(), true);
        createParagraph(ResManager.INSTANCE.getTime(date)+ " " + sdf.format(date),true);
    }
}
