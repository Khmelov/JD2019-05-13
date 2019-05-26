package by.it.zhukova.jd01_06;


public class TaskB1 {

    public static void main(String[] args) {
        String poem = (Poem.text);
        method1(poem);
    }

    private static void method1(String text) {
        String text2 = text.trim();
        String[] strArray = text2.split(" |\\-|\\.|\\,|\\:|\\!|\n");
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length()>1){
           if ((!(strArray[i].startsWith("а")))&&
            (!(strArray[i].startsWith("А")))&&
                   (!(strArray[i].startsWith("У")))&&
                   (!(strArray[i].startsWith("у")))&&
                   (!(strArray[i].startsWith("е")))&&
                   (!(strArray[i].startsWith("Е")))&&
                   (!(strArray[i].startsWith("Ы")))&&
                   (!(strArray[i].startsWith("ы")))&&
                   (!(strArray[i].startsWith("О")))&&
                   (!(strArray[i].startsWith("о")))&&
                   (!(strArray[i].startsWith("Э")))&&
                   (!(strArray[i].startsWith("э")))&&
                   (!(strArray[i].startsWith("Я")))&&
                   (!(strArray[i].startsWith("я")))&&
                   (!(strArray[i].startsWith("И")))&&
                   (!(strArray[i].startsWith("и")))&&
                   (!(strArray[i].startsWith("Ю")))&&
                   (!(strArray[i].startsWith("ю")))&&
                   (!(strArray[i].startsWith("Ё")))&&
                   (!(strArray[i].startsWith("ё")))
                   && (strArray[i].endsWith("а"))||
                   (strArray[i].endsWith("у"))||
                   (strArray[i].endsWith("е"))||
                   (strArray[i].endsWith("ы"))||
                   (strArray[i].endsWith("о"))||
                   (strArray[i].endsWith("э"))||
                   (strArray[i].endsWith("я"))||
                   (strArray[i].endsWith("и"))||
                   (strArray[i].endsWith("ю"))||
                   (strArray[i].endsWith("ё")))
                    System.out.println(strArray[i]);
                }
        }
            }
    }
