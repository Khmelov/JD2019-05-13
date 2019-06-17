package by.it.aadamovich.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {


    private HashMap<E, Object> hashMap = new HashMap<>();

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
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            hashMap.remove(o);
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {

        return hashMap.containsKey(o);
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
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
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        boolean isRemoved = false;
        for (Object o : c) {
            if (remove(o)) {
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    @Override
    public void clear() {

        hashMap.clear();
    }

    @Override
    public String toString() {
        String delimeter = "";
        StringBuilder strBuilder = new StringBuilder("[");
        Set<Map.Entry<E, Object>> entries = hashMap.entrySet();
        for (Map.Entry<E, Object> next : entries) {
            strBuilder.append(delimeter).append(next.getKey());
            delimeter = ", ";
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }


    // not implemented ----------------------------------------------------------------------

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
