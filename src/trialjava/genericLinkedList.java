package trialjava;

/**
 * Created by losandhu on 24-Jun-16.
 */
public class genericLinkedList<T> {
    MyNode<T> head = null;
    MyNode<T> tail = null;
    int count = 0;

    public static void main(String[] arg) {
        genericLinkedList l = new genericLinkedList();
        l.add(1);
        l.add(1.1);
        l.add("Hello");
        l.add(true);
        l.printList(l);
    }

    public void add(T i) {
        if (head == null) {
            head = new MyNode<T>();
            head.data = i;
            head.next = tail;
            tail = head;
        } else {
            tail.next = new MyNode<T>();
            tail = tail.next;
            tail.data = i;
        }
        count++;
    }

    private void printList(genericLinkedList l) {
        while (l.head != null && l.head != l.tail.next) {
            System.out.println(l.head.data);
            l.head = l.head.next;
        }
    }

    public class MyNode<T> {
        T data;
        MyNode<T> next;
    }
}
