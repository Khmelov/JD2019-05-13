package by.it.livanovich.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC <T> implements Set {

    private T [] elements= (T[]) new Object[] {};
    int size=0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (size==elements.length);
        elements=Arrays.copyOf(elements,size*3/2+1);
        if (o==null); elements[size++]= (T) o;
       for (int i = 0; i < size; i++) {
        if (!o.equals(elements[i])) {
            elements [size]= (T) o; size++;
       }}
        return false;
    }

    @Override
    public String toString() {
        Arrays.sort(elements);
        StringBuilder sb=new StringBuilder("[");
        String delimiter="";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter=", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
