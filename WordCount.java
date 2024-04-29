import java.util.Scanner;

    public class WordCount {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a text or provide a file to count the words:");
            String input = scanner.nextLine();

            String[] words = input.split("[\\s\\p{Punct}]+");
            int wordCount = words.length;

            System.out.println("Total words: " + wordCount);

            scanner.close();
        }
    }

