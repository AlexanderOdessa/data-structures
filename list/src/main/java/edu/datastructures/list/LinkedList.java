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
            newLast.setPrevious(last);
            last = newLast;
        }
        size++;
    }

    public void remove(int index) {
        checkBounds(index);
        ListElement<T> elementToDelete = first;
        for (int i = 0; i < index; i++) {
            elementToDelete = elementToDelete.getNext();
        }

        if (elementToDelete == first) {
            first = first.getNext();
            first.setPrevious(null);
        } else if (elementToDelete == last) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            ListElement<T> previous = elementToDelete.getPrevious();
            ListElement<T> next = elementToDelete.getNext();
            previous.setNext(next);
            next.setPrevious(previous);
        }

        if (elementToDelete == current) {
            ListElement<T> prevoius = current.getPrevious();
            current = current.getNext();
            if (current != null)  {
                current.setPrevious(prevoius);
            }
            if (prevoius != null) {
                prevoius.setNext(current);
            }
        }
        size--;
    }

    public T getFirst() {
        return first != null ? first.getElement() : null;
    }

    public T getLast() {
        return last != null ? first.getElement() : null;
    }

    public T getNext() {
        //TODO: current is not current now
        ListElement<T> next = current.getNext();
        if (next != null) {
            final T element = next.getElement();
            current = next;
            return element;
        } else {
            return null;
        }
    }

    public T getPrevious() {
        //TODO: current is not current now
        ListElement<T> previous = current.getPrevious();
        if (previous != null) {
            final T element = previous.getElement();
            current = previous;
            return element;
        } else {
            return null;
        }
    }

    public void setCurrentPosition(int index) {
        checkBounds(index);
        ListElement nextElement = first;
        for (int i = 0; i < index; i++) {
            nextElement = nextElement.getNext();
        }
        current = nextElement;
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
    }

}
