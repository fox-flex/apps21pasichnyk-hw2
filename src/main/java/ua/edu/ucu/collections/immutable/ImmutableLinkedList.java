package ua.edu.ucu.collections.immutable;

import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node head;
    private final Node tail;
    private final int length;

    public ImmutableLinkedList(Object[] elements) {
        length = elements.length;
        if (length == 0) {
            head = null;
            tail = null;
        } else {
            Node prev = null, node = new Node();
            head = node;
            for (Object el : elements) {
                node.setValue(el);
                node.setPrevious(prev);
                node.setNext(new Node());
                prev = node;
                node = node.getNext();
            }
            tail = prev;
            tail.setNext(null);
        }
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public ImmutableList add(Object element) {
        Object[] res = new Object[length+1];
        System.arraycopy(toArray(), 0, res, 0, res.length-1);
        res[res.length-1] = element;
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList add(int index, Object element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] data = toArray();
        Object[] res = new Object[length + 1];
        for (int i = 0; i < res.length; ++i) {
            res[i] = i < index ? data[i] : i == index ? element : data[i-1];
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList addAll(Object[] addData) {
        Object[] data = toArray();
        Object[] res = new Object[length + addData.length];
        for (int i = 0; i < res.length; ++i) {
            res[i] = i < data.length ? data[i] : addData[i - data.length];
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList addAll(int index, Object[] addData) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] data = toArray();
        Object[] res = new Object[length + addData.length];
        for (int i = 0; i < res.length; ++i) {
            res[i] = i < index ? data[i] : i < index + addData.length ? addData[i-index] : data[i - addData.length];
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i<index; ++i) {
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] data = toArray();
        Object[] res = new Object[length-1];
        int ind = 0;
        for (int i = 0; i < length; ++i) {
            if (i == index) {
                continue;
            }
            res[ind++] = data[i];
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList set(int index, Object element) {
        if (index < 0 || index >= length ) {
            throw new IndexOutOfBoundsException();
        }
        Object[] data = toArray();
        data[index] = element;
        return new ImmutableLinkedList(data);
    }

    @Override
    public int indexOf(Object element) {
        int pos = 0;
        Node now = head;
        while (now != null && now.getValue() != element) {
            now = now.getNext();
            ++pos;
        }
        if (pos == length) {
            throw new InputMismatchException();
        }
        return pos;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[length];
        Node now = head;
        for (int i=0; i<length; ++i) {
            res[i] = now.getValue();
            now = now.getNext();
        }
        return res;
    }

    public ImmutableLinkedList addFirst(Object element) {
        return (ImmutableLinkedList) add(0, element);
    }

    public ImmutableLinkedList addLast(Object element) {
        return (ImmutableLinkedList) add(length, element);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (head != null) {
            return head.getValue();
        }
        throw new InputMismatchException();
    }

    public Object getLast() {
        if (tail != null) {
            return tail.getValue();
        }
        throw new InputMismatchException();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(length-1);
    }
}
