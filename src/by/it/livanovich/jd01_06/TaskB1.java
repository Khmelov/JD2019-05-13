package by.it.livanovich.jd01_06;


import java.util.Arrays;

public class TaskB1 {
        public static void main(String[] args) {
        String[] word = Poem.text.split("\\s+|\\.+|\\,+|\\-+|\\:+");
         for (int i = 0; i < word.length; i++) {
            if (!word[i].startsWith("У")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э") || word[i].endsWith("ы")))
                if (!word[i].startsWith("у")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                    if (!word[i].startsWith("а")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                        if (!word[i].startsWith("А")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                            if (!word[i].startsWith("о")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                if (!word[i].startsWith("О")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                    if (!word[i].startsWith("И")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                        if (!word[i].startsWith("и")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                            if (!word[i].startsWith("е")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                                if (!word[i].startsWith("Е")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                                    if (!word[i].startsWith("ё")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                                        if (!word[i].startsWith("Ё")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                                            if (!word[i].startsWith("э")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                                                if (!word[i].startsWith("ю")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                                                    if (!word[i].startsWith("я")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))
                                                                        if (!word[i].startsWith("Я")&& (word[i].endsWith("и")|| word[i].endsWith("я") || word[i].endsWith("ю") || word[i].endsWith("а") || word[i].endsWith("е") || word[i].endsWith("ё") || word[i].endsWith("о") || word[i].endsWith("у") || word[i].endsWith("э")|| word[i].endsWith("ы")))

                System.out.println(word[i]);


        }
    }
}