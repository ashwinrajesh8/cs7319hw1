import java.io.*;
import java.util.*;

class pipenfilter {
    public static String readFileAsString(String fileName) throws Exception {
        String everything;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }
        return everything;
    }

    public static String cleanData(String data) {
        String dataOne = data.replaceAll("[!,.?\n]", "").toLowerCase();
        return dataOne;
    }

    public static void parseWords(String dataClean, Set<String> words) {
        String[] str = dataClean.split(" ");
        for (int i = 0; i < str.length; i++) {
            words.add(str[i]);
        }
    }

    public static void printUniqueWords(Set<String> words) {
        List<String> orderedWords = new ArrayList<String>(words);
        Collections.sort(orderedWords);
        for (String j : orderedWords) {
            System.out.println(j);
        }
    }

    private static class PipeRunner
            implements Runnable {
        public void run() {
            String data = ""; // Initialize data, this will be our first variable passed through pipe and
                              // filter
            try {
                Set<String> words = new HashSet<String>(); // Initialize our collection of unique words as an
                                                           // unpopulated hashset
                try {
                    data = readFileAsString("pftest.txt"); // Read input file and pass it into data variable
                } catch (Exception e) {
                    System.out.println("Problem reading input.");
                }
                String dataClean = cleanData(data); // Filter data to meet criterea and pass it into dataClean variable
                parseWords(dataClean, words); // Pass data from dataClean string into words hashset
                printUniqueWords(words); // Output unique words found in input (by first filtering the words hashset and
                                         // rearranging into alphabetically sorted array)
            } catch (Exception e) {
                System.out.println("Error upon running pipe and filter program.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new PipeRunner());
        t.start();
    }
}