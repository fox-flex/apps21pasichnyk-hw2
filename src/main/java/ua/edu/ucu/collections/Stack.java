package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList data;

    public Stack() {
        data = new ImmutableLinkedList();
    }

    public void push(Object element) {
        data = data.addLast(element);
    }

    public Object pop() {
        Object res = data.getLast();
        data = data.removeLast();
        return res;
    }

    public Object peek() {
        return data.getLast();
    }
}
