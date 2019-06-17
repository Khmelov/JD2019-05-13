package by.it.adamovichjr.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    private HashMap<E, Object> hashMap = new HashMap<>();

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {

        return hashMap.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        } else {
            hashMap.put(e, null);
            return true;
        }
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
    public boolean remove(Object o) {
        if(contains(o)){
            hashMap.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<? > c) {
        boolean removed = false;
        for (Object o : c) {
            if(remove(o)){
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contains = false;
        for (Object o : c) {
            if(contains(o)){
                contains = true;
            }
        }
        return contains;
    }

    @Override
    public void clear() {
        hashMap.clear();

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String delimetr = "";
        Iterator<Map.Entry<E, Object>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            sb.append(delimetr).append(iterator.next().getKey());
            delimetr = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
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
}


