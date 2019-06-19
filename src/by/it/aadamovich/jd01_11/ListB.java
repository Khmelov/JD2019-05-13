package by.it.aadamovich.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    private E[] array = (E[]) new Object[0];
    private int size = 0;

    @Override
    public boolean add(E e) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (size * 3) / 2 + 1);
        }
        array[size] = e;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (size * 3) / 2 + 1);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (size + c.size() > array.length) {
            array = Arrays.copyOf(array, c.size() + (size * 3) / 2 + 1);
        }
        for (E e : c) {
            array[size++] = e;
        }
        return true;
    }

    @Override
    public E remove(int index) {
        E buffer = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return buffer;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) remove(index);
        return (indexOf(o) > -1);
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        E buffer = array[index];
        array[index] = element;
        return buffer;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return (indexOf(o) > -1);
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String delimeter = "";
        StringBuilder strBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            strBuilder.append(delimeter).append(array[i]);
            delimeter = ", ";
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }


    // not implemented --------------------------------------------------------------------


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
