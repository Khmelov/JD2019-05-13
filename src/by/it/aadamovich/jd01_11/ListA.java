package by.it.aadamovich.jd01_11;


import java.util.*;

public class ListA<E> implements List<E> {

    private E[] array = (E[]) new Object[0];
    private int size = 0;


    @Override
    public boolean add(E e) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (size * 3) / 2 + 1);
        }
        array[size++] = e;
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
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    System.arraycopy(array, i + 1, array, i, size - i - 1);
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(o)) {
                    System.arraycopy(array, i + 1, array, i, size - i - 1);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        E buffer = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return buffer;
    }

    @Override
    public E get(int index) {
        return array[index];
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

    // not implemented -----------------------------------------------------------------


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
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
    public boolean addAll(Collection<? extends E> c) {
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
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
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
