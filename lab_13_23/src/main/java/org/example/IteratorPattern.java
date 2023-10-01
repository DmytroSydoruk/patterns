package org.example;

import java.util.ArrayList;
import java.util.List;


interface Iterator {
    boolean hasNext();
    Object next();
}


class ListIterator implements Iterator {
    private List<Object> collection;
    private int index = 0;

    public ListIterator(List<Object> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Object item = collection.get(index);
            index++;
            return item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}


interface Iterable {
    Iterator createIterator();
}


class ListCollection implements Iterable {
    private List<Object> collection;

    public ListCollection(List<Object> collection) {
        this.collection = collection;
    }

    @Override
    public Iterator createIterator() {
        return new ListIterator(collection);
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        List<Object> collection = new ArrayList<>();
        collection.add("laptop");
        collection.add("pc");
        collection.add("keyboard");
        collection.add("mouse");
        collection.add("camera");

        Iterable listCollection = new ListCollection(collection);
        Iterator iterator = listCollection.createIterator();

        while (iterator.hasNext()) {
            Object item = iterator.next();
            System.out.println(item);
        }
    }
}
