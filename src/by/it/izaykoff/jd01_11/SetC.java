package by.it.izaykoff.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

//    private E[] elements = (E[]) new Object[10];
//    private int size = 0;
//
//    @Override
//    public String toString() {
//        StringBuilder text = new StringBuilder("[");
//        String delimiter = "";
//        for (int i = 0; i < size; i++) {
//            if (elements[i].equals(elements[i+1])){
//                elements[i] = elements[i+1];
//            }
//            text.append(delimiter).append(elements[i]);
//            delimiter = ", ";
//        }
//        text.append("]");
//        return text.toString();
//    }
//
//    @Override
//    public boolean add(E e) {
//        boolean a = false;
//        if (size == elements.length){
//            elements = Arrays.copyOf(elements,elements.length*3/2+1);
//        }
//        for (int i = 0; i < elements.length; i++) {
//            if(e.equals(elements[i])){
//                elements[i] = e;
//                a=true;
//                break;
//            }
//        }
//        if(!a){
//            elements[size] = e;
//            size += 1;
//        }
//        return true;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return false;
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return null;
//    }
//
//    @Override
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    @Override
//    public <T> T[] toArray(T[] a) {
//        return null;
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        return false;
//    }
//
//    @Override
//    public boolean containsAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(Collection<? extends E> c) {
//        return false;
//    }
//
//    @Override
//    public boolean retainAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean removeAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }

    private HashSet<E> elements = new HashSet<>();


    @Override
public String toString() {
    StringBuilder sb = new StringBuilder("[");
    String delimiter = "";
    Iterator<E> iterator = elements.iterator();
    while(iterator.hasNext()){
        sb.append(delimiter).append(iterator.next());
        delimiter = ", ";
    }
    sb.append("]");
    return sb.toString();
}

    @Override
    public boolean add(E element) {
        if(!elements.contains(element)){
            elements.add(element);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        boolean empty = elements.isEmpty();
        return empty;
    }

    @Override
    public boolean contains(Object o) {
        if(elements.contains(o)){
            return  true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (elements.contains(o)) {
            elements.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E elem : c) {
            elements.add(elem);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            elements.contains(o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if (elements.contains(o)) {
                elements.remove(o);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        elements.clear();
    }

//    ------------------------------------------

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
}
