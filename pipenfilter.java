import java.io.*;
import java.util.*;

class pipenfilter {
    /* Initialize variables that will be passed through "pipes" */
    String data = "";
    String dataClean = "";
    Set<String> words = new HashSet<String>(); // Initialize our collection of unique words as an
                                               // unpopulated hashset

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
        public PipeRunner(String data) {
            try {
                data = readFileAsString("pftest.txt"); // Read input file and pass it into data variable
            } catch (Exception e) {
                System.out.println("Problem reading input.");
            }
        }

        public void run() {

        }
    }

    private static class PipeRunnerTwo
            implements Runnable {
        public PipeRunnerTwo(String dataClean, String data) {
            try {
                dataClean = cleanData(data); // Filter data to meet criterea and pass it into dataClean variable
            } catch (Exception e) {
                System.out.println("Error filtering and cleaning raw data.\n");
            }
        }

        public void run() {

        }
    }

    private static class PipeRunnerThree
            implements Runnable {
        public PipeRunnerThree(String dataClean, Set<String> words) {
            try {
                parseWords(dataClean, words); // Pass data from dataClean string into words hashset
            } catch (Exception e) {
                System.out.println("Error passing data into hashset.\n");
            }
        }

        public void run() {

        }
    }

    private static class PipeRunnerFour
            implements Runnable {
        public PipeRunnerFour(Set<String> words) {
            try {
                printUniqueWords(words); // Output unique words found in input (by first filtering the words hashset and
                                         // rearranging into alphabetically sorted array)
            } catch (Exception e) {
                System.out.println("Error upon sorting & outputting filtered dataset.\n");
            }
        }

        public void run() {

        }
    }

    public static void main(String[] args) throws Exception {
        /* Run threads of components */
        Thread t = new Thread(new PipeRunner(data));
        t.start();
        Thread u = new Thread(new PipeRunnerTwo(dataClean, data));
        u.start();
        Thread v = new Thread(new PipeRunnerThree(dataClean, words));
        v.start();
        Thread w = new Thread(new PipeRunnerFour(words));
        w.start();

        t.join();
        u.join();
        v.join();
        w.join();
    }
}