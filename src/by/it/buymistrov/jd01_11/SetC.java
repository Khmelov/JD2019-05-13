package by.it.buymistrov.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    private E[] elements = (E[]) new Object[100];
    private int size = 0;


    @Override
    public String toString() {

        StringBuilder txt = new StringBuilder("[");
        String delimetr = "";
        for (int i = 0; i < size; i++) {
            txt.append(delimetr).append(elements[i]);
            delimetr = ", ";
        }
        txt.append("]");

        return txt.toString();
    }

    @Override
    public boolean add(E e) {

        for (int i = 0; i < size; i++) {

            if (e == null && e == elements[i]) {

                return false;
            }

            if (e != null && e.equals(elements[i])) {

                return false;
            }
        }

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3 / 2 + 1));
        }
        elements[size++] = e;
        return true;

    }


    @Override
    public boolean remove(Object o) {
        return false;
    }


    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < size; i++) {

            if (elements[i] != null && elements[i].equals(o)) {
                return true;
            } else if (elements[i] == null && o == null) {
                return true;
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
    public boolean addAll(Collection<? extends E> c) {

        boolean added = false;
        for (E e : c) {
            if (add(e)) {
                added = true;
            }
        }
        return added;

    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object o : c) {

            if (!contains(o))
                return false;
        }
        return true;

    }


    @Override
    public boolean removeAll(Collection<?> c) {


        E[] objects = (E[]) c.toArray();


        for (int i = 0; i < objects.length; i++) {
            for (int i1 = 0; i1 < size; i1++) {
                if (objects[i] == (elements[i1])) {
                    System.arraycopy(elements, i1 + 1, elements, i1, elements.length - i1 - 1);
                    size--;

                }
            }
        }


        return true;
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public void clear() {
        size = 0;


    }
}
