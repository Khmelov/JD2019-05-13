package by.it.dilkevich.jd01_14;

import java.io.*;

public class TaskB {

    public static void main(String[] args) throws IOException {

        String filePath = System.getProperty("user.dir") + "/src/by/it/dilkevich/jd01_14/text.txt";
        String resultTXT = System.getProperty("user.dir") + "/src/by/it/dilkevich/jd01_14/resultTaskB.txt";
        File fileName = new File(filePath);
        String text = printCountWordsAndSignsInText(fileName);
        writeToFile(text, resultTXT);
    }

    private static void writeToFile(String text, String path) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(path))){
            br.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static String printCountWordsAndSignsInText(File fileName) throws IOException {

        FileReader reader = null;
        String result = null;
        int wordsCount = 0;
        int signsCount = 0;
        int pointCount = 0;
        boolean space = false;
        int dashCount = 0;
        char before = 'g';


        try {
            reader = new FileReader(fileName);

            int i = -1;
            do {
                i = reader.read();
                char ch = (char)i;

                if( Character.isLetter(ch)){

                    if(Character.isUpperCase(ch) && before == ' '){
                        continue;
                    }
                    else if(Character.isUpperCase(ch)){
                        ++wordsCount;
                    }

                    before = ch;

                }

                else if (ch == ' '){

                    ++wordsCount;
                    space = false;
                    before = ch;
                }
                //else if(!Character.isLetterOrDigit(ch) && ch != ' '){
                else if(ch == '!' || ch == '.' || ch == ',' || ch == '-' || ch == ':'){

                    if(ch == '-')
                        ++dashCount;
                    ++signsCount;
                    space = true;
                    if(ch == '.' && before == '.')
                        --signsCount;
                    before = ch;
                }
            }
            while (i !=-1);

            result = "words=" + (wordsCount+pointCount-dashCount) + (", punctuation marks=") + signsCount;
            System.out.printf("words=%d, punctuation marks=%d", wordsCount+pointCount-dashCount,signsCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(reader != null)
                reader.close();
        }

        return result;
    }


}