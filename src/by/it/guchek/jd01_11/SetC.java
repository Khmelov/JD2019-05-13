package by.it.guchek.jd01_11;

import java.util.*;

public class SetC <T> implements Set<T> {

    private T[] elements = (T[]) new Object[] {};

    private int size=0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter="";

        for (int i = 0; i < size; i++) {

            sb.append(delimeter).append(elements[i]);
            delimeter=", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    int countSize;
    @Override
    public boolean add(T t) {
        if (size==elements.length)
            elements= Arrays.copyOf(elements, (size*3/2)+1);  //увеличим длину массива по такой формуле как в станд JDK
        //теперь последний индекс точно больше чем переменная size
        boolean foundT = false;
        for (T e: elements) {
            if (t.equals(e)) {
                foundT = true;
            }
        }
        if(!foundT){
            elements[size]=t;
            size++;
        }

        // if(!contains(t)) {
        // elements[size]=t;
        // size++;
        // }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T e: elements) {
            if (Objects.equals(o, e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
       // for (T e : c) {
         //   if (!contains(e))
           // add(e);}
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
