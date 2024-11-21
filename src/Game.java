import java.util.Scanner;

public class Game {

    private Player player1, player2;
    private Scanner scanner = new Scanner(System.in); //Reads players input

    //Starts the game
    public void start(){
        System.out.println("Welcome to the game of Tic-Tac-Toe!");
        setupPlayer(); //Setup player details

        while (true){ //Loop to restart the game after each round
            System.out.println("Game over! Restarting...");
        }
    }

    private void setupPlayer(){
        System.out.println("Enter name for Player 1: ");
        String name1 = scanner.nextLine();
        player1 = new Player(name1, 'X'); //Player 1 will use X

        System.out.println("Enter name for Player 2: ");
        String name2 = scanner.nextLine();
        player2 = new Player(name1, 'O'); //Player 2 will use O
    }


}
