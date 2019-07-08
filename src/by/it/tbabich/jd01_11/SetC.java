package by.it.tbabich.jd01_11;

import java.util.*;

class SetC<T> implements Set<T> {

    private HashMap<T, Object> map = new HashMap<>();

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        } else {
            map.put(t, null);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            map.remove(o);
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e)) {
                return false;
            }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
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
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        Set<Map.Entry<T, Object>> entries = map.entrySet();
        for (Map.Entry<T, Object> element : entries) {
            sb.append(delimeter).append(element.getKey());
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
}
