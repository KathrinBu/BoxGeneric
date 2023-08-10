import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class MyBox <E> implements Collection {
    private E[] elements;
    private int size=0;

    public MyBox(){
        elements=(E[]) new Object[1];
    }
    @Override
    public boolean add(E e) {
        if (size==elements.length){
            elements = Arrays.copyOf(elements, size * 2);
        } elements[size++]=e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
    private class MyIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            return elements[currentIndex++];
        }


        @Override
        public void remove() {
            MyCollection.this.remove(elements[currentIndex]);
        }

    }
    }
