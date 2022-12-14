package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


/**
 * Performs some basic array deque tests.
 */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the array, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized ArrayDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        // should not be empty
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        // should be empty
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addFirst(3);

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        ArrayDeque<Double> ad2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<Boolean>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad1.removeLast());
    }

    @Test
    /* Tests if the get method works for a single item */
    public void singleItemGetTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        ad1.addFirst(0);

        int firstItem = ad1.get(0);

        assertEquals("Should return 0 when get is called on index 0", 0, firstItem);
    }

    @Test
    /** Fills a deque, then removes all items */
    public void FillThenEmptyTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        ad1.addLast(2);
        ad1.addFirst(1);
        ad1.addLast(3);
        ad1.addFirst(0);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);

        int firstRemoval = ad1.removeFirst();
        assertEquals("Should return 0 when removeFirst is called on deque with size of 8", 0, firstRemoval);
        assertEquals(7, ad1.size());

        int secondRemoval = ad1.removeLast();
        assertEquals("Should return 7 when removeFirst is called on update deque with size of 7", 7, secondRemoval);
        assertEquals(6, ad1.size());

        int thirdRemoval = ad1.removeFirst();
        assertEquals("Should return 1 when removeFirst is called on update deque with size of 6", 1, thirdRemoval);
        assertEquals(5, ad1.size());

        int fourthRemoval = ad1.removeLast();
        assertEquals("Should return 6 when removeFirst is called on update deque with size of 5", 6, fourthRemoval);
        assertEquals(4, ad1.size());

        int fifthRemoval = ad1.removeLast();
        assertEquals("Should return 5 when removeFirst is called on update deque with size of 4", 5, fifthRemoval);
        assertEquals(3, ad1.size());

        int sixthRemoval = ad1.removeLast();
        assertEquals("Should return 4 when removeFirst is called on update deque with size of 3", 4, sixthRemoval);
        assertEquals(2, ad1.size());

        int seventhRemoval = ad1.removeLast();
        assertEquals("Should return 3 when removeFirst is called on update deque with size of 2", 3, seventhRemoval);
        assertEquals(1, ad1.size());

        int eighthRemoval = ad1.removeLast();
        assertEquals("Should return 2 when removeFirst is called on update deque with size of 1", 2, eighthRemoval);
        assertEquals(true, ad1.isEmpty());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigArrayDequeTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }
    }

    @Test
    public void resizeItemsFirstIndexLessThanLastIndexDequeTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 5; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 9; i > 5; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }
    }

    @Test
    public void resizeItemsFirstIndexGreaterThanLastIndexDequeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 15; i >= 0; i--) {
            ad1.addFirst(i);
        }

        for (double i = 15; i > 8; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }

        for (double i = 0; i < 8; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addLast(0);
        ad1.addLast(1);
        ad1.addLast(2);

        assertEquals((Integer) 0, ad1.get(0));
        assertEquals((Integer) 1, ad1.get(1));
        assertEquals((Integer) 2, ad1.get(2));
        assertNull(ad1.get(-1));
        assertNull(ad1.get(3));
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addLast(1);

        Iterator<Integer> ad1Iterator = ad1.iterator();

        assertTrue(ad1Iterator.hasNext());

        int nextItem = ad1Iterator.next();

        assertEquals(1, nextItem);
        assertFalse(ad1Iterator.hasNext());
    }

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addLast(1);

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        ad2.addLast(1);

        ArrayDeque<Integer> ad3 = new ArrayDeque<Integer>();
        ad3.addLast(2);

        ArrayDeque<Integer> ad4 = new ArrayDeque<Integer>();
        ad4.addLast(1);
        ad4.addLast(2);

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addLast(1);

        int[] numArr = {1};

        assertTrue(ad1.equals(ad1));
        assertTrue(ad1.equals(ad2));
        assertFalse(ad1.equals(ad3));
        assertFalse(ad1.equals(ad4));
        assertTrue(ad1.equals(lld1));
        assertFalse(ad1.equals(numArr));
    }

    @Test
    public void deepEqualsTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        ad1.addLast("test");

        ArrayDeque<String> ad2 = new ArrayDeque<String>();
        ad2.addLast("test");

        ArrayDeque<ArrayDeque<String>> ad3 = new ArrayDeque<ArrayDeque<String>>();
        ad3.addLast(ad1);

        ArrayDeque<ArrayDeque<String>> ad4 = new ArrayDeque<ArrayDeque<String>>();
        ad4.addLast(ad2);

        assertTrue(ad3.equals(ad4));
    }
}
