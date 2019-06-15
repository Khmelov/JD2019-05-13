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

        if (size==0) {elements[0]=t;countSize++;}
        else for (int i = 0; i <size ; i++) {
        if (!elements[i].equals(t)){
            elements[size]=t;
            countSize = size++;
        }
            //size=countSize;
        }

        size=countSize;

        //return map.put(t, elrments)==null;

        return false;
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
