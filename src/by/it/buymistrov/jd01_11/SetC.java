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


        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2 / 3 + 1);

        }
        for (E element : elements) {
            if (element == e) {
                break;
            }
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

        for (E element : elements) {
            if (element == o) {
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

//////костыли. когда-нибудь поправлю
    @Override
    public boolean addAll(Collection<? extends E> c) {

        E[] objects = (E[]) c.toArray();
        System.out.println(Arrays.toString(objects));

        E[] elem = (E[]) new Object[elements.length + objects.length];

        System.arraycopy(elements, 0, elem, 0, elements.length);


        System.arraycopy(objects, 0, elem, size, objects.length);

        elements = Arrays.copyOf(elements, elements.length + objects.length);
        System.arraycopy(elem, 0, elements, 0, elem.length);


        size += objects.length - 2;


        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        E[] objects = (E[]) c.toArray();
        boolean r = true;


        for (int i = 0; i < objects.length; i++) {
            for (int i1 = 0; i1 < size; i1++) {
                if (objects[i] != elements[i1]) {
                    r = true;
                } else r = false;
            }
        }

        return r;
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
