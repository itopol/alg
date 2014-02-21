/**
 * User: igt
 */
public class StackLinkedListBased {
    private Node first;

    private class Node {
        String item;
        Node next;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push (String value) {
        Node oldfirst = first;
        first = new Node();
        first.item = value;
        first.next = oldfirst;
    }

    public String pop () {
        String item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        StackLinkedListBased s = new StackLinkedListBased();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
//        StdOut.println("(" + s.size() + " left on stack)");
    }

}
