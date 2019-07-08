package by.it.maniuk.calc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComplicatedBuilder extends DocumentBuilder {

    private Date date;
    private SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");

    ComplicatedBuilder ()  {
        date = new Date();
    }

    @Override
    public void createHeader() {
        createParagraph(ResManager.INSTANCE.getTime(date)+ " " + sdf.format(date),false);
    }


    @Override
    public void createParagraph(String parText, Boolean flag) {
        String path = getFilePath(SimpleBuilder.class, "reportComplicated.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(path, flag))) {
            out.print(parText);
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

