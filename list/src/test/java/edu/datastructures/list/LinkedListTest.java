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

        assertEquals("one", list.getNext());
        assertEquals("two", list.getNext());
        assertEquals("three", list.getNext());
        assertNull(list.getNext());
        assertNull(list.getNext());
        assertEquals("three", list.getPrevious());
        assertEquals("two", list.getPrevious());
        assertEquals("one", list.getPrevious());
        assertNull(list.getPrevious());

    }

    @Test
    public void testRemove() {
        list.remove(1);

        assertEquals(2, list.size);
        assertEquals("one", list.getNext());
        assertEquals("three", list.getNext());

        assertNull(list.getNext());
    }

    @Test
    public void testRemoveLowBorder() {
        list.remove(0);

        assertEquals(2, list.size);
        assertEquals("two", list.getNext());
        assertEquals("three", list.getNext());

        assertNull(list.getNext());
    }

    @Test
    public void testRemoveHighBorder() {
        list.remove(2);

        assertEquals(2, list.size);
        assertEquals("one", list.getNext());
        assertEquals("two", list.getNext());

        assertNull(list.getNext());
    }

}
