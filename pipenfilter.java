
// identify delimiters (' ', ',', '.', '!', '?')
// convert to lowercase
// find on datastruct
// if unique, then push to struct
// print out unique words
import java.io.*;

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

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("pftest.txt");
        System.out.println(data);
    }
}