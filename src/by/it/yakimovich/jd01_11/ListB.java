package by.it.yakimovich.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<E> implements List<E> {
    private E[] elements=(E[]) new Object[100];
    private int size=0;

    @Override
    public boolean add(E e) {
        if(size==elements.length){
            Arrays.copyOf(elements,elements.length+2/3+1);}
        elements[size++]=e;
        return true;
    }
    @Override
    public E remove(int index) {
        E element=elements[index];
        System.arraycopy(elements,index+1,elements,index,size-1-index);
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E elem=elements[index];
        System.arraycopy(elements,index,elements,index,size-index);
        elements[index]=element;
        return elem;
    }

    @Override
    public void add(int index, E element) {
        if(size==elements.length){
            Arrays.copyOf(elements,elements.length+2/3+1);}
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=element;
        size++;

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] object = (E[]) c.toArray();
        for (int i = 0; i <object.length ; i++) {
            add(object[i]);}
        return false;

        }



    @Override
    public String toString() {
        StringBuilder txt=new StringBuilder("[");
        String delimeter="";
        for (int i = 0; i < size; i++) {
            txt.append(delimeter).append(elements[i]);
            delimeter=", ";}
        txt.append(']');
        return txt.toString();
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public int size() {
        return elements.length;
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
    public boolean remove(Object o) {
        return false;
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
