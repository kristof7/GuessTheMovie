import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Game {


    public static void main(String[] args) throws IOException {


        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        //-----Random movie---------------------------

        String movieAtLine;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("movies.txt"));
        movieAtLine = bufferedReader.readLine();

        double randomNumber = Math.random();
        randomNumber = randomNumber * movieAtLine.length();
        randomNumber = randomNumber + 1;

        int randomInt = (int) randomNumber;
        String film = Files.readAllLines(Paths.get("movies.txt")).get(randomInt);

        String filmShort = film;

        //----film name compressed-----
        filmShort = filmShort.replaceAll(" ", "");

        System.out.println();
        System.out.println("Try to guess the name of the movie by entering the letters one by one");
        System.out.println("You will have 10 guesses");

        GameUI game = new GameUI();
        game.aGame(filmShort);
        GameUI.currentFilm(film);

    }

    public static void currentFilm(String current) {
        System.out.println("The title of the movie was: " + current);
    }
}