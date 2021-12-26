package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList linkedList;
    private ImmutableList immutableListMuted;
    private ImmutableLinkedList linkedListMuted;

    @Before
    public void setUp() {
        linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
    }

    @Test
    public void add() {
        immutableListMuted = linkedList.add(2);
        Object[] res = new Object[] {1,2,3,2};
        for (int i = 0; i< immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void testAdd() {
        immutableListMuted = linkedList.add(2, 5);
        Object[] res = new Object[] {1,2,5,3};
        for (int i = 0; i< immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void addAll() {
        immutableListMuted = linkedList.addAll(new Object[] {5,6});
        Object[] res = new Object[] {1,2,3,5,6};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void testAddAll() {
        immutableListMuted = linkedList.addAll(1, new Object[] {5,6});
        Object[] res = new Object[] {1,5,6,2,3};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void get() {
        Object[] res = new Object[] {1,2,3};
        for (int i = 0; i < linkedList.size(); ++i) {
            assertEquals(res[i], linkedList.get(i));
        }
    }

    @Test
    public void remove() {
        immutableListMuted = linkedList.remove(1);
        Object[] res = new Object[] {1,3};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void set() {
        immutableListMuted = linkedList.set(1, 6);
        Object[] res = new Object[] {1,6,3};
        for (int i = 0; i < immutableListMuted.size(); ++i) {
            assertEquals(res[i], immutableListMuted.get(i));
        }
    }

    @Test
    public void indexOf() {
        assertEquals(1, linkedList.indexOf(2));
        assertEquals(2, linkedList.indexOf(3));
    }

    @Test
    public void size() {
        assertEquals(3, linkedList.size());
    }

    @Test
    public void clear() {
        immutableListMuted = linkedList.clear();
        assertEquals(0, immutableListMuted.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(linkedList.isEmpty());
        immutableListMuted = linkedList.clear();
        assertTrue(immutableListMuted.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] array = linkedList.toArray();
        Object[] res = new Object[] {1,2,3};
        for (int i=0; i< array.length; ++i) {
            assertEquals(res[i], array[i]);
        }
    }

    @Test
    public void addFirst() {
        linkedListMuted = linkedList.addFirst(0);
        Object[] res = new Object[] {0,1,2,3};
        for (int i=0; i< linkedListMuted.size(); ++i) {
            assertEquals(res[i], linkedListMuted.get(i));
        }
    }

    @Test
    public void addLast() {
        linkedListMuted = linkedList.addLast(0);
        Object[] res = new Object[] {1,2,3,0};
        for (int i=0; i< linkedListMuted.size(); ++i) {
            assertEquals(res[i], linkedListMuted.get(i));
        }
    }

    @Test
    public void getHead() {
        Node node = linkedList.getHead();
        assertEquals(1, node.getValue());
    }

    @Test
    public void getTail() {
        Node node = linkedList.getTail();
        assertEquals(3, node.getValue());
    }

    @Test
    public void getFirst() {
        assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void getLast() {
        assertEquals(3, linkedList.getLast());
    }

    @Test
    public void removeFirst() {
        linkedListMuted = linkedList.removeFirst();
        Object[] res = new Object[] {2,3};
        for (int i=0; i < linkedListMuted.size(); ++i) {
            assertEquals(res[i], linkedListMuted.get(i));
        }
    }

    @Test
    public void removeLast() {
        linkedListMuted = linkedList.removeLast();
        Object[] res = new Object[] {1,2};
        for (int i=0; i < linkedListMuted.size(); ++i) {
            assertEquals(res[i], linkedListMuted.get(i));
        }
    }
}