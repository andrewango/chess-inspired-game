import java.util.*;

public class Team {

    // Member fields
    private String teamColor;
    private ArrayList<Piece> teamPieces;

    // 2-parameter Constructor
    public Team(String teamColor, ArrayList<Piece> teamPieces) {
        this.teamColor= teamColor;
        this.teamPieces = teamPieces;
    }

    // Accessors
    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }

    // Mutators
    public void removePieceFromTeam(Piece pieceToRemove) {
        teamPieces.remove(pieceToRemove);
    }

    public void addPieceToTeam(Piece pieceToAdd) {
        pieceToAdd.setTeamColor(teamColor);
        teamPieces.add(pieceToAdd);
    }

    @Override
    public String toString() {
        return ("Team " + teamColor + " Pieces :\n" + teamPieces).replace("[", "")
                .replace("]", "").replace(",", "");
    }
}
