package by.it.yakovets.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {

        String[] strArray = Poem.text.split("[,;:.!?\\s]+");
        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            char[] strChar = str.toCharArray();
            if (strChar.length > 1) {
                char f = strChar[0];
                char l = strChar[strChar.length - 1];

                if ((f == 'б' | f == 'в' | f == 'г' | f == 'д' | f == 'ж' | f == 'з' | f == 'й' | f == 'к' | f == 'л' | f == 'м' |
                        f == 'н' | f == 'п' | f == 'р' | f == 'с' | f == 'т' | f == 'ф' | f == 'х' | f == 'ц' | f == 'ч' | f == 'ш' | f == 'щ' |
                        f == 'Б' | f == 'В' | f == 'Г' | f == 'Д' | f == 'Ж' | f == 'З' | f == 'Й' | f == 'К' | f == 'Л' | f == 'М' | f == 'Н' |
                        f == 'П' | f == 'Р' | f == 'С' | f == 'Т' | f == 'Ф' | f == 'Х' | f == 'Ц' | f == 'Ч' | f == 'Ш' | f == 'Щ')
                        && (l == 'а' | l == 'е' | l == 'ё' | l == 'и' | l == 'о' | l == 'у' | l == 'ы' | l == 'э' | l == 'ю' | l == 'я')) {
                    System.out.println(strArray[i]);
                }

            }
        }
    }
}





