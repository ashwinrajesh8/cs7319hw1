package Pipey;

import java.io.*;
import java.util.*;

public class parseWords implements Runnable {
    String data;
    Set<String> words = new HashSet<String>(); // Initialize our collection of unique words as an
                                               // unpopulated hashset

    parseWords(String dataClean) {
        data = dataClean;
    }

    public void run() {
        String[] str = data.split(" ");
        for (int i = 0; i < str.length; i++) {
            words.add(str[i]);
        }
        new Thread(new printUniqueWords(words)).start();
    }
}
