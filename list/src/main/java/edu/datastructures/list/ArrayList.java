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
        currentIndex++;
    }

    public void set(int index, T element) {
        checkBounds(index);
        data[index] = element;
    }

    public T get(int index) {
        checkBounds(index);
        return (T) data[index];
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= currentIndex) {
            throw new IndexOutOfBoundsException("There is no element with index " + index);
        }
    }

    public void remove(int index) {
        checkBounds(index);
        currentIndex--;
        System.arraycopy(data, index + 1, data, index, currentIndex - index);
        data[currentIndex] = null;
    }

    public int size(){
        return currentIndex;
    }



}
