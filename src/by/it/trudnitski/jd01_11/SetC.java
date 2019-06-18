package by.it.trudnitski.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {
    private HashSet<E> elements=new HashSet<>();
    private int size=0;

    @Override
    public String toString() {
        StringBuilder txt=new StringBuilder("[");
        String delimeter="";
        Iterator<E> iterator=elements.iterator();
        while(iterator.hasNext()){
            txt.append(delimeter).append(iterator.next());
            delimeter=", ";
        }
        txt.append("]");
        return txt.toString();
    }

    @Override
    public boolean add(E e) {
       if(!elements.contains(e))
           elements.add(e);
        return true;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        boolean empty=elements.isEmpty();
        return empty;
    }

    @Override
    public boolean contains(Object o) {
       if(elements.remove(o)) {
           return true;
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
    public boolean remove(Object o) {
     if(elements.contains(o)) {
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
        for (E e : c) {
            elements.add(e);
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

    }
}
