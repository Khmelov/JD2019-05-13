package by.it.orlov.jd01_06;

import java.util.Arrays;

public class TaskB1 {
    public static void main(String[] args) {
        String text = Poem.text;
        String[] p = {",",".","!","-", ":", ";", "\n"};
        for (int i = 0; i < p.length; i++) {
            if (p[i] == "\n") {
                text = text.replace(p[i], " ");
            }else {
                text = text.replace(p[i], "");
            }
        }
        int[] space = find_space(text);
        String[] my_words = find_words(space,text);
        for (String my_word : my_words) {
            if(my_word.equals("Избушка")) {

            }else{
                System.out.print(my_word+"\n");
            }
        }
    }
    private static String[] find_words(int[] space, String text){
        String[] words = new String[0];
        int o = 0;
        char[] a = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у','ю', 'я','У', 'Е', 'Ё', 'А', 'О', 'Э', 'Я', 'И', 'Ю' };
        for (int i = 0; i < space.length-2; i++) {
            for (int l = 0; l < a.length; l++) {
                if (text.charAt(space[i]+1)!=a[l]){
                    for (int p = 0; p < a.length; p++) {
                        if((text.charAt(space[i+1]-1)==a[l])){
                            words = Arrays.copyOf(words,words.length+1);
                            words[o] = text.substring(space[i]+1,(space[i+1]));
                            o++;
                            break;
                        }
                    }
                    continue;
                }

            }
        }
        
        return words;
    }

    
    private static int[] find_space(String text){
        int pos = 0;
        int[] space = new int[1];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                space[pos] = i;
                pos++;
                space = Arrays.copyOf(space, space.length+1);
            }
        }
        return space;
    }

}
