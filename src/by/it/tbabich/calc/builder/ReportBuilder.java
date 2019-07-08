package by.it.tbabich.calc.builder;

import java.io.File;

abstract class ReportBuilder {

    void setHeadReport(HeadReport head){};
    void setFooterReport(FooterReport footer){};
    void setFile(String filename){};
    void addExpressionToBody(String expression){};
    void addExceptionToBody(Exception exception){};
    void setStringBuilder(StringBuilder bodyReport){};



    private static String getPath() {
        String root = System.getProperty("user.dir");
        String simpleName = ReportBuilder.class.getSimpleName();
        String name = ReportBuilder.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace("builder", "reports").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

    public static String getFilePath(String fileName) {
        return getPath() + fileName;
    }

}
