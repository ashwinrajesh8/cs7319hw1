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

    public static void parseWords(String data, Set<String> words) {
        String[] str = data.split(" ");
        for (int i = 0; i < str.length; i++) {
            words.add(str[i]);
        }
    }

    public static void printUniqueWords(Set<String> words) {
        for (String j : words) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) throws Exception {
        Set<String> words = new HashSet<String>();
        String data = readFileAsString("pftest.txt");
        data = cleanData(data);
        parseWords(data, words);
        printUniqueWords(words);
    }
}