import java.util.Scanner;
import java.io.*;

public class Hangman {
    private static String word;

    // Assigns word to getWord return
    static {
        try {
            word = getWord();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0;

    // Returns random word from words.txt
    public static String getWord() throws IOException {
        String text = "";
        int lineNumber;

        FileReader readfile = new FileReader("D:\\Code\\Java\\hagnman\\words.txt");
        BufferedReader readbuffer = new BufferedReader(readfile);

        int max = 999;
        int min = 1;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;

        for (lineNumber = 1; lineNumber < 999; lineNumber++) {
            if (lineNumber == rand) {
                text = readbuffer.readLine();
            } else
                readbuffer.readLine();
        }
        return text;
    }

    public static void hang(String guess) {
        StringBuilder newAsterisk = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newAsterisk.append(guess.charAt(0));
            } else if (asterisk.charAt(i) != '*') {
                newAsterisk.append(word.charAt(i));
            } else {
                newAsterisk.append("*");
            }
        }

        if (asterisk.equals(newAsterisk.toString())) {
            count++;
            hangmanImage();
        } else {
            asterisk = newAsterisk.toString();
        }
        if (asterisk.equals(word)) {
            System.out.println("You win! The word was " + word);
        }
    }

    // Creates graphic for when you guess wrong
    public static void hangmanImage() {
        switch (count) {
            case 1 -> {
                System.out.println("Wrong, try again");
                System.out.println("_____|_____");
            }
            case 2 -> {
                System.out.println("Wrong, try again");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("_____|_____");
            }
            case 3 -> {
                System.out.println("Wrong, try again");
                System.out.println("     ____________");
                System.out.println("     |/");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     | ");
                System.out.println("_____|_____");
            }
            case 4 -> {
                System.out.println("Wrong, try again");
                System.out.println("     _____________");
                System.out.println("     |/         _|_");
                System.out.println("     |         /   \\");
                System.out.println("     |        |     |");
                System.out.println("     |         \\_ _/");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("_____|_____");
            }
            case 5 -> {
                System.out.println("Wrong, try again");
                System.out.println("     _____________");
                System.out.println("     |/         _|_");
                System.out.println("     |         /   \\");
                System.out.println("     |        |     |");
                System.out.println("     |         \\_ _/");
                System.out.println("     |           |");
                System.out.println("     |           |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("_____|_____");
            }
            case 6 -> {
                System.out.println("Wrong, try again");
                System.out.println("   ____________");
                System.out.println("   |/         _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |          / \\ ");
                System.out.println("   |         /   \\");
                System.out.println("   |");
                System.out.println("___|___");
            }
            case 7 -> {
                System.out.println("Wrong, try again");
                System.out.println("     ____________");
                System.out.println("     |/         _|_");
                System.out.println("     |         /   \\");
                System.out.println("     |        |     |");
                System.out.println("     |         \\_ _/");
                System.out.println("     |          _|_");
                System.out.println("     |         / | \\");
                System.out.println("     |          / \\ ");
                System.out.println("     |         /   \\");
                System.out.println("     |");
                System.out.println("_____|_____");
            }
            case 8 -> {
                System.out.println("GAME OVER!");
                System.out.println("     ____________");
                System.out.println("     |/         _|_");
                System.out.println("     |         /   \\");
                System.out.println("     |        | x x |");
                System.out.println("     |         \\_ _/");
                System.out.println("     |          _|_");
                System.out.println("     |         / | \\");
                System.out.println("     |          / \\ ");
                System.out.println("     |         /   \\");
                System.out.println("     |");
                System.out.println("_____|_____");
                System.out.println("GAME OVER! The word was " + word);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (count < 8 && asterisk.contains("*")) {
            System.out.println("Guess any letter in the word");
            System.out.println(asterisk);
            String guess = sc.next();
            hang(guess);
        }
        sc.close();
    }
}