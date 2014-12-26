package edu.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

    }

}
