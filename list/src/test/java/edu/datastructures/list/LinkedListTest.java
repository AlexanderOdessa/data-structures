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

    }

    @Test
    public void testRemove() {
        list.remove(1);

        assertEquals(2, list.size);
        assertEquals("one", list.get(0));
        assertEquals("three", list.get(1));

    }

    @Test
    public void testRemoveLowBorder() {
        list.remove(0);

        assertEquals(2, list.size);
        assertEquals("two", list.get(0));
        assertEquals("three", list.get(1));

    }

    @Test
    public void testRemoveHighBorder() {
        list.remove(2);

        assertEquals(2, list.size);
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));

    }

}
