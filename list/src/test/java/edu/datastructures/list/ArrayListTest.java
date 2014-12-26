package edu.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ArrayListTest {

    private ArrayList<String> defaultCapacityList;

    @Before
    public void init() {

        defaultCapacityList = new ArrayList<String>();

        defaultCapacityList.add("one");
        defaultCapacityList.add("two");
        defaultCapacityList.add("three");

    }

    @Test
    public void testAdd() {

        assertEquals("one", defaultCapacityList.get(0));
        assertEquals("two", defaultCapacityList.get(1));
        assertEquals("three", defaultCapacityList.get(2));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBounsMax() {

        defaultCapacityList.get(3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBounsMin() {

        defaultCapacityList.get(-1);

    }

    @Test
    public void testSet() {
        defaultCapacityList.set(1, "TWO");

        assertEquals("TWO", defaultCapacityList.get(1));
        assertNotEquals("two", defaultCapacityList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBounsMax() {

        defaultCapacityList.set(3, "qwe");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBounsMin() {

        defaultCapacityList.set(-1, "qwe");

    }

    @Test
    public void testSize() {

        assertEquals(3, defaultCapacityList.size());

    }

}
