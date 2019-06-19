package by.it.maniuk.jd01_06;

public class TaskB1 {
    static char[] consonants = "бвгджзйклмнпрстфхцчшщ".toCharArray();
    static char[] lowers = "аоиеёэыуюя".toCharArray();


    public static void main(String[] args) {

       //  char[] text = Poem.text.toCharArray();

        String text = Poem.text;
        text = text.replaceAll("\\n", " ");

        text = text.replaceAll("\\,", " ");
        text = text.replaceAll("\\:", " ");
        text = text.replaceAll("\\.", " ");
        text = text.replaceAll("\\-", "");

        text.split(" ");
        String[] strArray = text.trim().split(" ");
        find(strArray);
    }

    private static void find(String[] strArrey) {

        for (int i = 0; i <strArrey.length ; i++) {
            if (strArrey[i].length() < 1) continue;
           char[] a = strArrey[i].toCharArray();
            if (Character.isWhitespace(a[0])&& (a.length<=1)) continue;
            for (char consonant : consonants)
                if (Character.toLowerCase(a[0]) == consonant) {
                    for (char lower : lowers) {
                        int s = a.length - 1;
                        if ((a[s]) == lower) print(a);


                    }
                    break;
                }

                     }
//        boolean space = false;
//        int end = 0;
//        int start = 0;
//        int w = 0;
//        boolean word = false;
//        boolean endOfArray = false;
//        while (w <= text.length) {
//
//           if (Character.isWhitespace(text[w])) {space = true;}
//           if(space) {
//           for (int i = 0; i <= consonants.length-1; i++) {
//
//                if (consonants[i] == Character.toLowerCase(text[w]) && space) {
//                    start = w;
//                    word = true;
//                    space = false;
//                    break;
//                }
//            }}
//           if (word&&space){
//               for (int i = 0; i <= lowers.length-1; i++) {
//                   if (lowers[i] == text[w-1]) {
//                       end = (w - 1);
//                       word = false;
//                       space=false;
//                        w = end;
//                   }
//
//               }
//               if (end == 0) break;
//               for (int i1 = start; i1 <= end; i1++) {
//                    System.out.print(text[i1]);
//                }
//               System.out.println();
//
//                end =0;
//                start=0;
//
//            }
//            w++;
//        }
//
    }



    static void print(char[] text) {
        for (int i1 =0; i1 <=text.length-1; i1++) {
                   System.out.print(text[i1]);
               }
        System.out.println();

        }
    }



            

