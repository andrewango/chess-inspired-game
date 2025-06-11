public interface Recruiter {

    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);
    public abstract boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);
}