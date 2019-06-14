package by.it.dnevar.jd01_11;

import java.util.*;

public class SetC <E> implements Set<E> {

    private HashSet<E> elements = new HashSet<>();

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        boolean empt = elements.isEmpty();
        return empt;
    }

    @Override
    public boolean contains(Object o) {
        if(elements.contains(o)){
            return  true;
        }
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
    public boolean add(E element) {
        if(!elements.contains(element)){
            elements.add(element);
            return true;
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
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            elements.contains(o);
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E elem : c) {
            elements.add(elem);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
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
}
