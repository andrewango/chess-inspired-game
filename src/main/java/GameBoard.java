public class GameBoard {
    // Member fields
    private int rows;
    private int columns;
    private BoardSquare[][] squares;

    // Constructor
    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        squares = new BoardSquare[rows][columns];
        setUpEmptyBoard();
    }

    // Accessors
    public int getNumRows() {
        return rows;
    }

    public int getNumColumns() {
        return columns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }

    public boolean inBounds(int rowIndex, int columnIndex) {
        if (rowIndex < rows && rowIndex >= 0 && columnIndex < columns && columnIndex >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Assign BoardSquares to 2-dimensional BoardSquares array
    private void setUpEmptyBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                    if ((c % 2 == 0) && (r % 2 == 0) || (c % 2 == 1) && (r % 2 == 1)) {
                        squares[r][c] = new BoardSquare("Blue");
                    }
                    else {
                        squares[r][c] = new BoardSquare("Pink");
                    }
            }
        }
    }

    // Find random empty space and return the board square at that location
    public BoardSquare findRandomEmptySpace() {
        int rowIndex;
        int columnIndex;

        do {
            rowIndex = (int) (Math.random() * (rows));
            columnIndex = (int) (Math.random() * (columns));
        }
        while (!(squares[rowIndex][columnIndex].isEmpty()));
        return squares[rowIndex][columnIndex];
    }

    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
