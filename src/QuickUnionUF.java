/**
 * User: igt
 */
public class QuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Return the number of components.
     * @return the number of components (between 1 and N)
     */
    public int count() {
        return count;
    }

    /**
     * Return the component identifier for the component containing object p.
     * @param p the integer representing one object
     * @return the component identifier for the component containing object p
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    /**
     * Are the two objects p and q in the same component?
     * @param p the integer representing one object
     * @param q the integer representing the other object
     * @return true if the objects p and q are in the same component; false otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * Merge components containing p and q.
     * @param p the integer representing one object
     * @param q the integer representing the other object
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j;
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input,
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
