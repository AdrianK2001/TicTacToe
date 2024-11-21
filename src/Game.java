import java.util.Scanner;

public class Game {

    private GameBoard board = new GameBoard();
    private Player player1, player2;
    private Scanner scanner = new Scanner(System.in); //Reads players input


    //Starts and restarts the game
    public void start() {
        System.out.println("Welcome to the game of Tic-Tac-Toe!");
        setupPlayer(); //Setup player details

        while (true) { //Loop to restart the game after each round
            board.initializeBoard();
            playGame();
            System.out.println("Game over! Restarting...");
        }
    }

    private void setupPlayer() {
        System.out.println("Enter name for Player 1: ");
        String name1 = scanner.nextLine();
        player1 = new Player(name1, 'X'); //Player 1 will use X

        System.out.println("Enter name for Player 2: ");
        String name2 = scanner.nextLine();
        player2 = new Player(name2, 'O'); //Player 2 will use O
    }

    private void playGame() {


        boolean gameOn = true; //Checks if the game is still active
        Player currentPlayer = player1; // Player1 starts game

        while (gameOn) {
            board.printBoard(); //Show current board
            System.out.println(currentPlayer.getPlayerName() + "'s turn (" + currentPlayer.getPlayerSymbol() + ")");

            int row, col;
            while (true) {
                //Ask current player for input
                System.out.print("Enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                col = scanner.nextInt();

                //Validate the move
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isSpaceEmpty(row, col)) {
                    break; //Valid move, exit the loop
                }
                System.out.println("Invalid input. Try again."); // Invalid move
            }

            //Update the board with the current player symbol
            board.updateSpace(row, col, currentPlayer.getPlayerSymbol());

            //Check if the current player has won
            if (board.checkWinner(currentPlayer.getPlayerSymbol())) {
                board.printBoard();
                System.out.println("Congratulations " + currentPlayer.getPlayerName() + "! You win!");
                gameOn = false; //End game
            } else if (board.isFull()) { //Check for draw
                board.printBoard();
                System.out.println("It's a draw!");
                gameOn = false; //End game
            } else {
                //Switch to next player
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }
}