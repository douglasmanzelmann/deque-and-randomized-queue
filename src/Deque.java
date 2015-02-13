import java.util.Iterator;

/**
 * Created by dmanzelmann on 2/13/15.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            last = first;
        }
        else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
        }
    }

    public void addLast(Item item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            last = first;
        }
        else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            oldLast.next = last;
        }
    }

    //public Item removeFirst() {}

    //public Item removeLast() {}

    public Iterator<Item> iterator() { return new DequeIterator(); }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public void remove() { }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> d = new Deque<Integer>();

        d.addLast(0);
        d.addFirst(2);
        d.addFirst(1);
        d.addLast(3);

        for (Integer i : d) {
            System.out.print(i + " ");
        }
    }
}
