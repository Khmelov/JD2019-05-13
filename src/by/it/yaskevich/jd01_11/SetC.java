package by.it.yaskevich.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<E> implements Set<E> {
    private E[] elements = (E[])new Object[100];
    private boolean hasElementNull = false;
    private int size = 0;

    @Override
    public boolean add(E e) {
        if (e == null) {
            if (!hasElementNull) {
                hasElementNull = true;
                return true;
            }
        } else {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            Arrays.sort(elements, 0, size);
            if (Arrays.binarySearch(elements, 0, size, e) < 0) {
                elements[size++] = e;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            if (hasElementNull){
                hasElementNull = false;
                return true;
            }
        } else {
            int index = -1;
            try {
                index = Arrays.binarySearch(elements, 0, size, o);
            } catch (ClassCastException e) {
            }

            if (index >= 0) {
                System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return hasElementNull;
        } else {
            int index = -1;
            try {
                index = Arrays.binarySearch(elements, 0, size, o);
            } catch (ClassCastException e) {
            }
            return index >= 0;
        }
    }

    @Override
    public int size() {
        return size + (hasElementNull ? 1 : 0);
    }

    @Override
    public boolean isEmpty() {
        return (size == 0) && !hasElementNull;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
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
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        String delimiter = "";
        if (hasElementNull) {
            builder.append((Object)null);
            delimiter = ", ";
        }
        for (int i = 0; i < size; i++) {
            builder
                    .append(delimiter)
                    .append(elements[i]);
            delimiter = ", ";
        }
        builder.append("]");
        return builder.toString();
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

    @Override
    public void clear() {
        hasElementNull = false;
        Arrays.fill(elements, null);
        size = 0;
    }
}
