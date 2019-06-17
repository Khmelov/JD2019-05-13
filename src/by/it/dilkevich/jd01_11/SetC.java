package by.it.dilkevich.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};

    private int size = 0;
    private boolean isVarContain = false;

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object o : c) {

            if (!contains(o))
                return false;
        }
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {

        boolean modified = false;
        for (T e : c)

                if (add(e))
                    modified = true;

        return modified;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        boolean sizeN = false;
        for (Object o : c) {

            if(remove(o))
                sizeN = true;

        }
        return sizeN;
    }

    @Override
    public void clear() {
        size = 0;
    }

    public void add(int index, T element) {

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3 / 2 +1 ));
        }

        System.arraycopy(elements, index, elements, index+1, size - index);
        elements[index] = element;
        size++;

    }


    public T set(int index, T element) {

        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
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

        for (int i = 0; i < size; i++) {

            if(elements[i] != null && elements[i].equals((T)o)){
                return true;
            }
            else if(elements[i] == null && o == null){
                return true;
            }
        }
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
    public boolean add(T t) {

        for (int i = 0; i < size; i++) {

            if (t == null && t == elements[i]){

                return  false;
            }

            if (t != null && t.equals(elements[i])){

                return false;
            }
        }

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3 / 2 +1 ));
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        int index = -1;

        for (int i = 0; i < size; i ++) {

            if (elements[i] == (T) o) {

                index = i;
            }

            if (index > -1) {

                T temp = elements[index];
                System.arraycopy(elements, index + 1, elements, index, size - index-1);
                size--;
                return true;
            }
        }
        return false;
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

}
