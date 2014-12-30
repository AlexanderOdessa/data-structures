package edu.datastructures.list;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class LinkedList<T> {

    protected ListElement<T> first;
    protected ListElement<T> last;
    protected int size;

    public void add(T element) {
        if (first == null) {
            first = last = new ListElement<T>(element);
        } else {
            ListElement<T> newLast = new ListElement<T>(element, last);
            last.setNext(newLast);
            newLast.setPrevious(last);
            last = newLast;
        }
        size++;
    }

    public void remove(int index) {
        checkBounds(index);
        

        size--;
    }

    public T getFirst() {
        return first != null ? first.getElement() : null;
    }

    public T getLast() {
        return last != null ? first.getElement() : null;
    }

    public T get(int index) {
        checkBounds(index);
        ListElement<T> curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        if (curr != null) {
            return curr.getElement();
        } else {
            throw new IndexOutOfBoundsException("There is no such element with index " + index);
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("There is no such element with index " + index);
        }
    }

    protected static class ListElement<E> {
        private E element;
        private ListElement<E> previous;
        private ListElement<E> next;

        public ListElement(E element) {
            this.element = element;
        }

        public ListElement(E element, ListElement<E> previous) {
            this.element = element;
            this.previous = previous;
        }

        public ListElement(E element, ListElement<E> previous, ListElement<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public ListElement<E> getPrevious() {
            return previous;
        }

        public void setPrevious(ListElement<E> previous) {
            this.previous = previous;
        }

        public ListElement<E> getNext() {
            return next;
        }

        public void setNext(ListElement<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

}
