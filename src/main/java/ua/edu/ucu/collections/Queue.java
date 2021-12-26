package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList data;

    public Queue() {
        this.data = new ImmutableLinkedList();
    }

    public Object peek() {
        return data.getFirst();
    }

    public Object dequeue() {
        Object toDequeue = data.getFirst();
        data = data.removeFirst();
        return toDequeue;
    }

    public void enqueue(Object element) {
        data = (ImmutableLinkedList) data.add(element);
    }
}
