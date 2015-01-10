package com.company.interfaces;

/**
 * Created by bbr on 08.01.15.
 */
public interface MyCollection<E> {

    public boolean isEmpty();
    public boolean contains(E element);
    public void clear();
    public int size();
    public boolean equals(MyCollection anotherQueue);
    public void printIt();
}
