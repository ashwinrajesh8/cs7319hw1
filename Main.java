package Pipey;

public class Main {
    public static void main(String[] args) {
        new Thread(new readFileAsString("pftest.txt")).start();
    }
}
