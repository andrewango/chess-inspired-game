public class BoardSquare {
    // Member fields
    private boolean emptySpace;
    private Piece piece;
    private String color;


    public BoardSquare(String color) {
        this.color = color;
        emptySpace = true;
    }

    // Accessors
    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return emptySpace;
    }

    public String getSquareColor() {
        return color;
    }

    // Mutators
    public void setPiece(Piece piece) {
        this.piece = piece;
        this.emptySpace = false;
    }

    public Piece removePiece() {
        Piece oldPiece = piece;
        piece = null;
        emptySpace = true;
        return (oldPiece);
    }

    @Override
    public String toString() {
        if (emptySpace) {
            return ("-------");
        }
        else {
            return ("-" + piece + "-");
        }
    }
}
