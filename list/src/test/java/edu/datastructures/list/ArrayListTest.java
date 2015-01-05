package edu.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
    public void testRemove() {

        assertEquals(3, defaultCapacityList.size());

        defaultCapacityList.remove(1);

        assertEquals(2, defaultCapacityList.size());

        assertEquals("one", defaultCapacityList.get(0));
        assertEquals("three", defaultCapacityList.get(1));

        try{
            defaultCapacityList.get(2);
            assertTrue(false);
        } catch (IndexOutOfBoundsException ex) {
            assertTrue(true);
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounsMax() {

        defaultCapacityList.remove(3);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounsMin() {

        defaultCapacityList.remove(-1);

    }

    @Test
    public void testSize() {

        assertEquals(3, defaultCapacityList.size());

    }

    @Test
    public void testAddSize() {
        defaultCapacityList.add("four");
        defaultCapacityList.add("five");
        defaultCapacityList.add("six");
        defaultCapacityList.add("seven");
        defaultCapacityList.add("eight");
        defaultCapacityList.add("nine");
        defaultCapacityList.add("ten");

        assertEquals(10, defaultCapacityList.data.length);

        defaultCapacityList.add("eleven");

        assertEquals(20, defaultCapacityList.data.length);

        assertEquals("one", defaultCapacityList.get(0));
        assertEquals("eleven", defaultCapacityList.get(10));
    }

    @Test
    public void testSubSize() {
        defaultCapacityList.add("four");
        defaultCapacityList.add("five");
        defaultCapacityList.add("six");
        defaultCapacityList.add("seven");
        defaultCapacityList.add("eight");
        defaultCapacityList.add("nine");
        defaultCapacityList.add("ten");
        defaultCapacityList.add("eleven");

        assertEquals(20, defaultCapacityList.data.length);

        defaultCapacityList.remove(3);

        assertEquals(20, defaultCapacityList.data.length);

        assertEquals("one", defaultCapacityList.get(0));
        assertEquals("three", defaultCapacityList.get(2));
        assertEquals("five", defaultCapacityList.get(3));
        assertEquals("eleven", defaultCapacityList.get(9));

        for (int i = 0; i < 4; i++) {
            defaultCapacityList.remove(3);
        }

        assertEquals(20, defaultCapacityList.data.length);
        assertEquals(6, defaultCapacityList.size);

        defaultCapacityList.remove(3);

        assertEquals(10, defaultCapacityList.data.length);
        assertEquals(5, defaultCapacityList.size);

        assertEquals("one", defaultCapacityList.get(0));
        assertEquals("two", defaultCapacityList.get(1));
        assertEquals("three", defaultCapacityList.get(2));
        assertEquals("ten", defaultCapacityList.get(3));
        assertEquals("eleven", defaultCapacityList.get(4));

        System.out.println(defaultCapacityList);

    }

    @Test
    public void testIterable() {
        int i = 0;
        for (String s: defaultCapacityList) {
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
