import java.security.PublicKey;
import java.util.Scanner;

public class GameUI {


    public void aGame(String film) {

        String hidden = new String(new char[film.length()]).replace('\0', '_');
        Scanner scanner = new Scanner(System.in);

        int guessNumber = 10;
        String lettersGuessed = "";

        System.out.println("Film to guess(hidden):  " + hidden);
        System.out.println("Input first letter (use only lower-case letters):");

        //----Game loop-start---------------------
        for (int i = 0; i <= 10; i++) {
            char guess = scanner.next().charAt(0);


            //----Inner loop-start------------------
            boolean checkGuess = lettersGuessed.contains(String.valueOf(guess));

            for (int j = 0; j < film.length(); j++) {
                if (guess == film.charAt(j)) {
                    char[] charHidden = hidden.toCharArray();
                    charHidden[j] = guess;
                    hidden = String.valueOf(charHidden);

                } else if (checkGuess) {
                    System.out.println("You already choose this letter, try again..");
                    break;
                }

            }

            //----Inner loop-end------------------
            boolean guessContains = film.contains(String.valueOf(guess));
            if (!guessContains && !checkGuess) {
                System.out.println("Wrong letter!");
            } else if (film.equals(hidden)) {
                System.out.println("YOU WIN!!");
                break;
            }
            if (guessNumber == 1) {
                System.out.println("YOU LOOSE!!");
                break;
            }

            guessNumber--;

            if (lettersGuessed.contains(String.valueOf(guess)) == false) {
                lettersGuessed = lettersGuessed + String.valueOf(guess) + ", ";
            }
            System.out.println("You have " + guessNumber + " guesses left");
            System.out.println("Letter guessed: " + lettersGuessed);
            System.out.println("Film to guess:  " + hidden);
        }
    }

    public static void currentFilm(String current) {
        System.out.println("The title of the movie was: " + current);
    }
}
