package by.it.adamovichjr.jd01_11;

import java.util.*;

public class SetC<T> implements Set {
    private T[] elements = (T[]) new Object[]{};

    private int size = 0;

    @Override
    public boolean add(Object o) {
        boolean find = false;
        for (T element : elements) {
            if(element == (T)o)
                find = true;
        }
        if(find == false && size == elements.length){
            elements = Arrays.copyOf(elements,(size*3)/2+1);
        }
        if(find == false){
            elements[size++] = (T) o;
        }
        return find;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if(elements[i] == (T)o){
                System.arraycopy(elements,i+1,elements,i,size-i-1);
                size--;
                return true;
            }

        }
        return false;
    }
    @Override
    public boolean removeAll(Collection c) {
        Iterator<T> it = c.iterator();
        while (it.hasNext()){
            for (int i = 0; i < size; i++) {
                if(it == elements[i]){
                    System.arraycopy(elements,i+1,elements,i,size-i-1);
                    size--;
                }
            }
        }
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
        boolean find = false;
        for (T element : elements) {
            if(element == (T)o){
                find = true;
                break;
            }
        }
        return find;
    }

    @Override
    public boolean containsAll(Collection c) {

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimetr = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimetr).append(elements[i]);
            delimetr = ", ";
        }
        sb.append("]");
        return sb.toString();
    }



    @Override
    public Spliterator spliterator() {
        return null;
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
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
