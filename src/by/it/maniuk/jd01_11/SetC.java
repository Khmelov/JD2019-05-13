package by.it.maniuk.jd01_11;


import java.util.*;

public class SetC <T> implements Set<T> {
    private T[] elements =  (T[]) new Object[]{};
    private int[] ints = new int[]{};
    private int size = 0;
    private int threshold = 0;
    private HashMap<T, Object> hashMap = new HashMap<>();


    @Override
    public String toString(){
        StringBuilder txt = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            txt.append(delimeter).append(elements[i]);
            delimeter =", ";
        }
        txt.append("]");
        return txt.toString();
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        } else {
            hashMap.put(t, null);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {

            if (contains(o)) {
                hashMap.remove(o);
                return true;
            }
            return false;
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
    public boolean contains(Object o) {
        return hashMap.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
    public boolean addAll(Collection<? extends T> c) {
         boolean added = false;
        for (T arr : c) {
            if (add(arr)) {
                added = true;
            }
        }
        return added;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for (Object o : c) {
            if(remove(o)){
                removed = true;
            }
        }
        return removed;
    }


    @Override
    public void clear() {
        hashMap.clear();
    }
}
