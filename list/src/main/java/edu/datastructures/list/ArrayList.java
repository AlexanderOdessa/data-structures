package edu.datastructures.list;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ArrayList<T> {

    protected Object[] data;
    protected static final int DEFAULT_INITIAL_CAPACITY = 10;
    protected int currentIndex = 0;

    public ArrayList() {
        data = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public void add(T element) {
        data[currentIndex] = element;
    }

    public T get(int index) {
        return null;
    }

    public void remove(int index) {

    }

}
