package edu.datastructures.list;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class LinkedList<T> {

    protected ListElement<T> first;
    protected ListElement<T> last;
    protected ListElement<T> current;
    protected int size;

    public void add(T element) {
        if (first == null) {
            first = last = current = new ListElement<T>(element);
        } else {
            ListElement<T> newLast = new ListElement<T>(element, last);
            last.setNext(newLast);
            last = newLast;
        }
        size++;
    }

    public void remove() {
        // TODO: implement
        size--;
    }

    public T getFirst() {
        return first != null ? first.getElement() : null;
    }

    public T getLast() {
        return last != null ? first.getElement() : null;
    }

    public T getNext() {
        if (current != null) {
            final T element = current.getElement();
            current = current.getNext();
            return element;
        } else {
            return null;
        }
    }

    public T getPrevious() {
        final T element = current.getElement();
        current = current.getPrevious();
        return element;
    }

    public void setCurrentPosition(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("There is no such element with index " + index);
        }
        ListElement nextElement = first;
        for (int i = 0; i < index; i++) {
            nextElement = nextElement.getNext();
        }
        current = nextElement;
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
    }

}
