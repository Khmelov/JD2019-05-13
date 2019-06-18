package by.it.kobrinets.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[100];
    private int size = 0;


    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2 / 3 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public T remove(int index) {
        T buffer = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return buffer;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T buffer = elements[index];
        elements[index] = element;
        return buffer;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2 / 3 + 1);
        }
        System.arraycopy(elements,index,elements,index+1,size-index);
        size++;
        elements[index]=element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (size + c.size() > elements.length) {
            elements = Arrays.copyOf(elements, c.size() + (size * 3) / 2 + 1);
        }
        for (T e : c) {
            elements[size++] = e;
        }
        return true;
    }

    @Override
    public String toString() {
        String delimeter = "";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    //Не реализованы:

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
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
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
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
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
