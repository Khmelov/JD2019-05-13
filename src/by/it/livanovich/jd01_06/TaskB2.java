package by.it.livanovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text=Poem.text;
        text=text.replace("... "," ");
        text=text.replace(","," ");
        text=text.replace("\n"," ");
        String [] poem=text.split("\\.");
        for (String s : poem) {
            System.out.println(s);
        }
        }
    }

