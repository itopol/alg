import java.util.Iterator;

/**
 * User: igt
 */
public class Queue<Item> implements Iterable<Item> {
    Node<Item> first = null;
    Node<Item> last = null;
    int N=0;


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.next = null;
        last.item = item;
        if(isEmpty()) first = last;
        else oldLast.next = last;

        N++;
    }

    public Item dequeue() {
        Item item = first.item;

        first = first.next;



    }

    private class ListIterator<Item> implements Iterator<Item> {
        Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Node<Item> node = current;
            current = node.next;
            return node.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        first = null;
    }
}
