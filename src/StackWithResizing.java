/**
 * User: igt
 */
public class StackWithResizing {
    private int N;
    private String[] array;

    StackWithResizing() {
        array = new String[2];
    }

    public boolean isEmpty() {
        return N==0;
    }

    public void push(String value) {
        if (N==array.length) resize(2*array.length);
        array[N++] = value;
    }

    public String pop() {
        String item = array[N-1];
        array[N-1] = null;
        if(N==array.length/4) resize(array.length/2);
        N--;
        return item;
    }

    public int size() {
        return N;

    }

    public int stackSize() {
        return array.length;

    }

    private void resize (int capacity) {
        assert capacity >= N;
        String[] temp = new String[capacity];
        for (int i=0; i<N; i++) {
            temp[i] = array[i];
        }
        array=temp;
    }

    public static void main(String[] args) {
        StackWithResizing s = new StackWithResizing();
        while (!StdIn.isEmpty()) {

            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
            StdOut.println("(" + s.size() + " left on stack)");
            StdOut.println("(" + s.stackSize() + " stack size)");
        }

    }
}
