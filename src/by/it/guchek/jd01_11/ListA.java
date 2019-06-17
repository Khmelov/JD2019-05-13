package by.it.guchek.jd01_11;

import java.util.*;

public class ListA <E> implements List <E> {

    private E[] elements = (E[]) new Object[] {};   // массив обджектов необходимо скастить к типу Е

    // Сделаем так чтобы при удалении элемента длина массива не уменьшалась
    // храним размер в следующем поле

    private int size=0;     //который изначально равен 0


    @Override
    public boolean add(E e) { //сначала проверим длину
        if (size==elements.length)
            elements= Arrays.copyOf(elements, (size*3/2)+1);  //увеличим длину массива по такой формуле как в станд JDK
        //теперь последний индекс точно больше чем переменная size
            elements[size]=e;
            size++;

        return false;
    }

    @Override
    public void add(int index, E element) {

        if (size==elements.length)
            elements = Arrays.copyOf(elements, (size * 3 / 2) + 1);  //увеличим длину массива по такой формуле как в станд JDK
            //теперь последний индекс точно больше чем переменная size
            System.arraycopy(elements, index, elements, index+1, size-index);

            elements[index]=element;
            size++;


    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E remove(int index) {
        E delElem = elements[index];
        //if (size==elements.length)
        //    elements = Arrays.copyOf(elements, (size * 3 / 2) + 1);  //увеличим длину массива по такой формуле как в станд JDK
        //теперь последний индекс точно больше чем переменная size
        System.arraycopy(elements, index+1, elements, index, size-index-1);

        size--;
        return delElem;

    }


    @Override
    public E get(int index) {

        return elements[index];
    }

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

    /////



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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
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
    public E set(int index, E element) {
        return null;
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
