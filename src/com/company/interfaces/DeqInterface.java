package com.company.interfaces;

/**
 * Created by bbr on 08.01.15.
 */
public interface DeqInterface<E> extends MyCollection<E> {

    public void pushFirst(E element);
    public void pushLast(E element);
    public <E> E popFirst();
    public <E> E popLast();
    public <E> E peekFirst();
    public <E> E peekLast();
}
