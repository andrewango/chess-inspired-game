public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numAttacks);
    public abstract boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);
}
