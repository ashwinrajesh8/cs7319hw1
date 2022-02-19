package Pipey;

import java.io.*;
import java.util.*;

public class printUniqueWords implements Runnable {
    Set<String> words;

    printUniqueWords(Set<String> wordy) {
        words = wordy;
    }

    public void run() {
        List<String> orderedWords = new ArrayList<String>(words);
        Collections.sort(orderedWords);
        for (String j : orderedWords) {
            System.out.println(j);
        }
    }
}
