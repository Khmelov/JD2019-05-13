package by.it.buymistrov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {
        String[] words = new String[0];

        int len = 0;
        char[] vowels = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я', 'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};
        char[] consonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Щ', 'Ш'};


        StringBuilder text = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = compile.matcher(text);

        while (matcher.find()) {
            String word = matcher.group();
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = word;
        }


        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int s = 0; s < consonants.length; s++) {
                String consonant = Character.toString(consonants[s]);
                if (word.startsWith(consonant)) {
                    for (int g = 0; g < vowels.length; g++) {
                        String vowel = Character.toString(vowels[g]);
                        if (word.endsWith(vowel)) {
                            System.out.println(word);



                        }
                    }
                }

            }


        }
    }


}


