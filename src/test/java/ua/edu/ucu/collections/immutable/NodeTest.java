package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    private Node node1;
    private Node node2;

    @Before
    public void setUp() {
        this.node1 = new Node();
        this.node2 = new Node();
        this.node1.setValue("rrr");
        this.node2.setValue("dodo");
    }

    @Test
    public void testTestToString() {
        assertEquals("rrr" , node1.toString());
    }

    @Test
    public void getPrevious() {
        node1.setPrevious(node2);
        assertEquals(node1.getPrevious().getValue(), node2.getValue());
    }

    @Test
    public void setPrevious() {
        node1.setPrevious(node2);
        assertEquals(node1.getPrevious().getValue(), node2.getValue());
    }

    @Test
    public void getValue() {
        assertEquals(node1.getValue(), "rrr");
    }

    @Test
    public void setValue() {
        node1.setValue("biba");
        assertEquals(node1.getValue(), "biba");
    }

    @Test
    public void getNext() {
        node1.setNext(node2);
        assertEquals(node1.getNext().getValue(), node2.getValue());
    }

    @Test
    public void setNext() {
        node1.setNext(node2);
        assertEquals(node1.getNext().getValue(), node2.getValue());
    }
}