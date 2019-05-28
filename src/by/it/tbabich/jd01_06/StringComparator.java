package by.it.tbabich.jd01_06;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    public int compare(String string1, String string2) {
        if (string1.length() == string2.length())
            return 0;
        if (string1.length() > string2.length())
            return 1;
        else return -1;
    }
}
