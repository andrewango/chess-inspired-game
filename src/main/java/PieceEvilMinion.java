public class PieceEvilMinion extends PieceMinion implements Recruiter, Attacker {
    private boolean hungry;
    private int numAttacks;

    public static int MAX_NUM_ATTACKS = 4;

    public PieceEvilMinion(char symbol, String teamColor,
                       int numRecruits, int numAttacks, int numTimesSpawned,
                       boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    public PieceEvilMinion() {
        this('E', "NON", 0, 0, 0, false, true);
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public boolean canAttack() {
        return hungry;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public void updateHungry() {
        if (numAttacks < MAX_NUM_ATTACKS) {
            hungry = true;
        }
        else {
            hungry = false;
        }
    }

    @Override
    public void speak() {
        System.out.println("Roar!");
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }

    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }

    @Override
    public PieceEvilMinion spawn() {
        numTimesSpawned++;
        return new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0,
                0, false, false);
    }

    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                  int toSquareRow, int toSquareCol) {
        return true;
    }
}
