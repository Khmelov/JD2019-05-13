package by.it.maniuk.jd01_11;


import java.util.*;

public class SetC <T> implements Set<T> {
    private T[] elements =  (T[]) new Object[]{};
    private int[] ints = new int[]{};
    private int size = 0;
    private int threshold = 0;
    HashMap<T,Object> map;

    public SetC() {
        map = new HashMap<>();
    }

    @Override
    public String toString(){
        StringBuilder txt = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            txt.append(delimeter).append(elements[i]);
            delimeter =", ";
        }
        txt.append("]");
        return txt.toString();
    }

    @Override
    public boolean add(T t) {
        int s = t.hashCode();
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size*3)/2+1);
        }
        elements[size++] = t;
    return true;
    }

    @Override
    public boolean remove(Object o) {

        return false;
    }


    @Override
    public int size() {
        return size;
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
