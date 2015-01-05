package edu.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class LinkedListTest {

    private LinkedList<String> list;

    @Before
    public void init() {

        list = new LinkedList<>();

        list.add("one");
        list.add("two");
        list.add("three");

    }

    @Test
    public void testAddList() {

        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        
        assertEquals("one", list.getFirst());
        assertEquals("three", list.getLast());

    }

    @Test
    public void testNext() {

        LinkedList.ListElement<String> element = list.first;
        assertEquals("one", element.getElement());

        element = element.getNext();
        assertEquals("two", element.getElement());

        element = element.getNext();
        assertEquals("three", element.getElement());

        element = element.getNext();
        assertNull(element);

    }

    @Test
    public void testPrevoius() {

        LinkedList.ListElement<String> element = list.last;
        assertEquals("three", element.getElement());

        element = element.getPrevious();
        assertEquals("two", element.getElement());

        element = element.getPrevious();
        assertEquals("one", element.getElement());

        element = element.getPrevious();
        assertNull(element);

    }

    @Test
    public void testRemove() {
        list.remove(1);

        assertEquals(2, list.getSize());
        assertEquals("one", list.get(0));
        assertEquals("three", list.get(1));

    }

    @Test
    public void testRemoveLowBorder() {
        list.remove(0);

        assertEquals(2, list.getSize());
        assertEquals("two", list.get(0));
        assertEquals("three", list.get(1));

    }

    @Test
    public void testRemoveHighBorder() {
        list.remove(2);

        assertEquals(2, list.getSize());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));

    }

    @Test
    public void testIterable() {

        int i = 0;
        for(String s: list) {
            switch (i) {
                case 0: assertEquals("one", s); break;
                case 1: assertEquals("two", s); break;
                case 2: assertEquals("three", s); break;
                default: assertTrue(false);
            }
            i++;
        }

        assertEquals(3, i);

    }

}
