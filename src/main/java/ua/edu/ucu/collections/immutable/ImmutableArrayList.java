package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] data;

    public ImmutableArrayList(Object[] elements) {
        data = Arrays.copyOf(elements, elements.length);
    }

    public ImmutableArrayList() {
        data = new Object[0];
    }

    @Override
    public ImmutableList add(Object element) {
        Object[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length-1] = element;
        return new ImmutableArrayList(newData);
    }

    @Override
    public ImmutableList add(int index, Object element) {
        Object[] newData = new Object[data.length];
        int i = 0;
        for ( ; i<index; ++i) {
            newData[i] = data[i];
        }
        newData[i++] = element;
        for ( ; i<newData.length; ++i) {
            newData[i] = data[i-1];
        }
        return new ImmutableArrayList(newData);
    }

    @Override
    public ImmutableList addAll(Object[] addedData) {
        Object[] newData = Arrays.copyOf(data, data.length + addedData.length);
        System.arraycopy(addedData, 0, newData, data.length, addedData.length);
        return new ImmutableArrayList(newData);
    }

    @Override
    public ImmutableList addAll(int index, Object[] addedData) {
        Object[] res = new Object[data.length + addedData.length];
        for (int i = 0; i < res.length; ++i) {
            res[i] = i < index ? data[i] : i < index + addedData.length ? addedData[i-index] : data[i - addedData.length];
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] res = new Object[data.length-1];
        int ind = 0;
        for (int i = 0; i < data.length; ++i) {
            if (i == index) {
                continue;
            }
            res[ind++] = data[i];
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public ImmutableList set(int index, Object element) {
        Object[] newData = toArray();
        newData[index] = element;
        return new ImmutableArrayList(newData);
    }

    @Override
    public int indexOf(Object element) {
        for (int i=0; i<data.length; ++i) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, data.length);
    }
}
