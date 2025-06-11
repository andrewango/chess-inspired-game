import java.util.*;

public abstract class Game {

    // Member fields
    private GameBoard gameBoard;
    private Team team1;
    private Team team2;
    private String turn;

    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();

    private void initializeGameBoard(int numRows, int numColumns) {
        gameBoard = new GameBoard(numRows, numColumns);
        for (Piece piece : team1.getTeamPieces()) {
            BoardSquare emptySpace = gameBoard.findRandomEmptySpace();
            emptySpace.setPiece(piece);
        }
        for (Piece piece : team2.getTeamPieces()) {
            BoardSquare emptySpace = gameBoard.findRandomEmptySpace();
            emptySpace.setPiece(piece);
        }
    }

    // 4-parameter Constructor
    public Game(int boardRows, int boardCols, Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        turn = team1.getTeamColor();
        initializeGameBoard(boardRows, boardCols);
    }

    // Accessor
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public boolean isTurn(Team team) {
        if (turn == team.getTeamColor()) {
            return true;
        }
        else {
            return false;
        }
    }

    public Team getCurrentTeam() {
        if (isTurn(team1)) {
            return team1;
        }
        else {
            return team2;
        }
    }

    public Team getOpponentTeam() {
        if (!isTurn(team1)) {
            return team1;
        }
        else {
            return team2;
        }
    }

    public BoardSquare[][] getBoardSquares() {
        return gameBoard.getSquares();
    }

    // Mutators
    public void changeTurn() {
        if (isTurn(team1)) {
            turn = team2.getTeamColor();
        }
        else {
            turn = team1.getTeamColor();
        }
    }

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns() * 8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }
}
