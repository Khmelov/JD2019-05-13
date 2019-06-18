package by.it.dilkevich.jd01_11;


import java.util.*;

public class ListA<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public T get(int index) {

        return elements[index];
    }

    @Override
    public T remove(int index) {

        T temp = elements[index];
        System.arraycopy(elements, index+1, elements, index, size - index);
        size--;
        return temp;
    }

    @Override
    public boolean remove(java.lang.Object o) {
        return false;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(java.lang.Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public java.lang.Object[] toArray() {
        return new java.lang.Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            txt.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        txt.append("]");
        return txt.toString();
    }

    @Override
    public boolean add(T t) {

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3 / 2 +1 ));
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public T set(int index, T element) {
        return null;
    }

    @Override
    public int indexOf(java.lang.Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(java.lang.Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
