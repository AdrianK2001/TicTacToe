public class GameBoard {

    private char[][] board; //3x3 game board in a 2D array
    private final int size = 3; //The board size is really simple to change due to this command, just swap out "3" to any number desired.

    //Starts the board
    public GameBoard() {
        board = new char[size][size];
        initializeBoard();
    }

    //Fills empty spaces with '-'
    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-'; //More simple design of the board so I don't have to do as many lines
            }
        }
    }

    //Print current board state
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); //Move to next line after each row
        }
    }

    //Check for empty space
    public boolean isSpaceEmpty(int row, int col) {
        return board[row][col] == '-';
    }

    //Update board with player symbol
    public void updateSpace(int row, int col, char symbol) {
        if(isSpaceEmpty(row, col)) {
            board[row][col] = symbol;
        }
    }

    // Checks if a player has won
    public boolean checkWinner(char symbol) {
        //Check rows and columns for win
        for (int i = 0; i < size; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) || //Row win
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) { //Column win
                return true;
            }
        }

        //Check diagonals for win
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    //Check for draw
    public boolean isFull(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') { //If one space is left the board will not be registered as full
                    return false;
                }
            }
        }
        return true; //The board is full
    }

}
