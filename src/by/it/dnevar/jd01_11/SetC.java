package by.it.dnevar.jd01_11;

import java.util.*;

public class SetC <E> implements Set<E> {

    private E[] elements = (E[]) new Set[]{};
    private int size = 0;


    @Override
    public boolean add(E element) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements,size*3/2+1);
        }
        for (E elem : elements) {
            if(!elem.equals(element)) {
                elements[size++] = element;
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        if(elements.length==0){
            return  true;
        }else{
            return false;
        }

    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";

        }
        sb.append("]");
        return sb.toString();
    }

    //-----------------------------------------------------------

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
