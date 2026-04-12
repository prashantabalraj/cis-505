/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.util.LinkedList;

public class GenericQueue<E> {

    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E item) {
        list.addFirst(item);
    }

    public E dequeue() {
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }
}