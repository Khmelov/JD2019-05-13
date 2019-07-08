package by.it.maniuk.calc;


import java.io.File;

public abstract class DocumentBuilder {
   public abstract void createHeader();
   public abstract void createParagraph(String parText, Boolean flag);
   public abstract void createBody();


   static String getFilePath(Class<?> aClass, String filename) {
      return getPath(aClass) + filename;
   }

   private static String getPath(Class<?> aClass) {
      String root = System.getProperty("user.dir");
      String name = aClass.getName();
      String simpleName = Printer.class.getSimpleName();
      String separator = File.separator;
      String path = name.replace(simpleName, "").replace(".", separator);

      path = root + separator + "src" + separator + path;
      return path;
   }
}

