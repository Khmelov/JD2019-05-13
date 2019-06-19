package by.it.zhukova.jd01_11;

import java.util.*;

public class ListB <E> implements List<E> {
    private E [] elements = (E[])  new Object[100];
    private int size = 0;
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(E e) {
        if (size==elements.length){
            elements= Arrays.copyOf(elements,size*2/3+1);
        }
        elements [size++]=e;
        return true;
    }

    @Override
    public E remove(int index) {
        E element = elements[index];
        System.arraycopy(elements,index+1,elements,index,size-index-1);
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E elementdel = elements[index];
        elements[index]=element;
        return elementdel;
    }

    @Override
    public void add(int index, E element) {
                System.arraycopy(elements,index,elements,index+1,size-index);
                size++;
        elements[index]=element;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E [] objects = (E[]) c.toArray();
             System.arraycopy(objects,0,elements,size,objects.length);
        size+=objects.length;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            out.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        out.append("]");
        return out.toString();
    }

    //______________________________________________________________
    @Override
    public boolean remove(Object o) {
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
