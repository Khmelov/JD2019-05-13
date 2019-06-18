package by.it.buymistrov.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {



    private E[] elements = (E[]) new Object[100];
    private int size = 0;
    ///////////////////////////////////////////////

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


    ////////////////////////////////////


    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2 / 3 + 1);

        }
        elements[size++] = e;


        return true;
    }

    /////////////////////////////////////

    @Override
    public E remove(int index) {
        E element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return element;
    }


    ///////////////////////////////////////


    @Override
    public E get(int index) {
        return elements[index];
    }


    ////////////////////////////////////////


    @Override
    public E set(int index, E element) {

        E retEl = (E) elements[index];

        elements[index] = element;


        return retEl;


    }

    ///////////////////////////////////////


    @Override
    public void add(int index, E element) {

        E[] elem = (E[]) new Object[elements.length + 1];
        elements = Arrays.copyOf(elements, elements.length + 1);
        System.arraycopy(elements, 0, elem, 0, index);
        elem[index] = element;
        System.arraycopy(elements, index, elem, index + 1, elements.length - index - 1);
        System.arraycopy(elem, 0, elements, 0, elem.length);


        size++;

    }


    /////////////////////////////////////


    @Override
    public boolean addAll(Collection<? extends E> c) {


        Object[] objects = c.toArray();
        E[] elem = (E[]) new Object[elements.length + objects.length];

        System.arraycopy(elements, 0, elem, 0, elements.length);


        System.arraycopy(objects, 0, elem, size, objects.length);


        elements = Arrays.copyOf(elements, elements.length + objects.length);
        System.arraycopy(elem, 0, elements, 0, elem.length);


        size += objects.length;

        return false;
    }


    //////////////////////////////////////////////////////


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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }


    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
