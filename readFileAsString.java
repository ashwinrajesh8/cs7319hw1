package Pipey;

import java.io.*;
import java.util.*;

public class readFileAsString implements Runnable {
    String fileName;
    String everything;

    readFileAsString(String name) {
        fileName = name;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (Exception e) {
            System.out.println("File parsing failed.\n");
        }
        // System.out.println(everything);
        new Thread(new cleanData(everything)).start();
    }
}
