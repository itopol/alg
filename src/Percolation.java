public class Percolation {
    private int top, bottom, seed;
    public WeightedQuickUnionUF grid;
    public boolean[] state;

    public Percolation(int N) {
        seed = N;
        int sz = N*N;
        top = 0; bottom = 1;
        grid = new WeightedQuickUnionUF(sz+2);

        state = new boolean[sz+2];
        state[0] = true; state[sz+1] = true;
        //connect to first N to top
        for (int i = 1; i < N; i++) {

        }

    }

    private int position(int row, int col) {

        return row;
    }

    public boolean isOpen(int row, int col) {

        return false;
    }

    public double openCount() {

        return 0;
    }

    public boolean isFull(int row, int col) {

        return false;
    }

    public int xyTo1D(int row, int col) {
       return row + col*seed-1;

    }

    public boolean percolates() {
        return grid.connected(top,bottom);
    }

    private void validate(int i, int j) {
        if(i < 0 || i > seed || j < 0 || j > seed)
            throw new IndexOutOfBoundsException();
    }

    public void open(int row, int col) {
    }

}