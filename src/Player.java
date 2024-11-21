public class Player {
    private String playerName; //The players name
    private char playerSymbol; //Players symbol (X or O)

    //Initializes the players name and symbol
    public Player(String playerName, char playerSymbol) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    //Returns player name
    public String getPlayerName() {
        return playerName;
    }

    //Returns player symbol
    public char getPlayerSymbol() {
        return playerSymbol;
    }
}
