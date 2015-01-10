package com.company.interfaces;

import com.company.interfaces.MyCollection;

/**
 * Created by efir758 on 07.01.2015.
 */
public interface StackInterface<E> extends MyCollection<E> {

    public void push(E element);
    public <E> E pop();
    public <E> E peek();
    //TODO PrintIt
}
