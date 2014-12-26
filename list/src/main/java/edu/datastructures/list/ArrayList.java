package edu.datastructures.list;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ArrayList<T> {

    protected Object[] data;
    protected static final int DEFAULT_INITIAL_CAPACITY = 10;
    protected int size = 0;

    public ArrayList() {
        data = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public void add(T element) {
        if (size == data.length) {
            Object[] tmpData = new Object[data.length * 2];
            System.arraycopy(data, 0, tmpData, 0, data.length);
            data = tmpData;
        }
        data[size] = element;
        size++;
    }

    public void set(int index, T element) {
        checkBounds(index);
        data[index] = element;
    }

    public T get(int index) {
        checkBounds(index);
        return (T) data[index];
    }

    protected void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("There is no element with index " + index);
        }
    }

    public void remove(int index) {
        checkBounds(index);
        size--;
        System.arraycopy(data, index + 1, data, index, size - index);
        data[size] = null;
        int quarterIndex = data.length / 4;
        final int halfIndex = quarterIndex * 2;
        if (size == quarterIndex) {
            Object[] tmpData = new Object[halfIndex];
            System.arraycopy(data, 0, tmpData, 0, halfIndex);
            data = tmpData;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("( ");
        final int i1 = size - 1;
        for (int i = 0; i < size; i++) {
            sb.append("\"");
            sb.append(data[i].toString());
            sb.append("\"");

            if (i < i1) {
                sb.append(", ");
            }
        }
        sb.append(" )");
        return sb.toString();
    }
}
