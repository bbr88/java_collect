package com.company.interfaces;

import com.company.interfaces.MyCollection;

/**
 * Created by bbr on 08.01.15.
 */
public interface QueueInterface<E> extends MyCollection<E> {

    public void pushLast(E element);
    public <E> E popFirst();
    public <E> E peekFirst();
    //TODO PrintIt

}
