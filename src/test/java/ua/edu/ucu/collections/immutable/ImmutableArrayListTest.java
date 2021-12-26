package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList immutableArrayList;
    private ImmutableList immutableListMuted;

    @Before
    public void setUp() {
        immutableArrayList = new ImmutableArrayList(new Object[] {1, 2, 3});
    }

    @Test
    public void add() {
        immutableListMuted = immutableArrayList.add(2);
        Object[] res = new Object[] {1,2,3,2};
        for (int i = 0; i< immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void testAdd() {
        immutableListMuted = immutableArrayList.add(2, 5);
        Object[] res = new Object[] {1,2,5,3};
        for (int i = 0; i< immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void addAll() {
        immutableListMuted = immutableArrayList.addAll(new Object[] {5,6});
        Object[] res = new Object[] {1,2,3,5,6};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void testAddAll() {
        immutableListMuted = immutableArrayList.addAll(1, new Object[] {5,6});
        Object[] res = new Object[] {1,5,6,2,3};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void get() {
        Object[] res = new Object[] {1,2,3};
        for (int i = 0; i < immutableArrayList.size(); ++i) {
            assertEquals(res[i], immutableArrayList.get(i));
        }
    }

    @Test
    public void remove() {
        immutableListMuted = immutableArrayList.remove(1);
        Object[] res = new Object[] {1,3};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void set() {
        immutableListMuted = immutableArrayList.set(1, 6);
        Object[] res = new Object[] {1,6,3};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void indexOf() {
        assertEquals(1, immutableArrayList.indexOf(2));
        assertEquals(2, immutableArrayList.indexOf(3));
    }

    @Test
    public void size() {
        assertEquals(3, immutableArrayList.size());
    }

    @Test
    public void clear() {
        immutableListMuted = immutableArrayList.clear();
        assertEquals(0, immutableListMuted.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(immutableArrayList.isEmpty());
        immutableListMuted = immutableArrayList.clear();
        assertTrue(immutableListMuted.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] array = immutableArrayList.toArray();
        Object[] res = new Object[] {1,2,3};
        for (int i=0; i< array.length; ++i) {
            assertEquals(res[i], array[i]);
        }
    }
}