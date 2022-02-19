package Pipey;

import java.io.*;
import java.util.*;

public class cleanData implements Runnable {
    String data;

    cleanData(String copyData) {
        data = copyData;
    }

    public void run() {
        String dataOne = data.replaceAll("[!,.?\n]", "").toLowerCase();
        // System.out.println(dataOne);
        new Thread(new parseWords(dataOne)).start();
    }
}
