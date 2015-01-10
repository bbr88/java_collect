package com.company.realization;

import com.company.interfaces.MyCollection;
import com.company.interfaces.QueueInterface;

/**
 * Created by bbr on 08.01.15.
 */
public class MyLinkedQueue<E> implements QueueInterface<E> {

    public MyLinkedQueue() {
        this.size = 0;
        this.elements = new MyLinkedList();
    }

    @Override
    public void pushLast(E element) {
        size++;
        elements.addLast(element);
    }

    @Override
    public <E> E popFirst() {
        size--;
        return (E)elements.deleteFirst();
    }

    @Override
    public <E> E peekFirst() {
        return (E)elements.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(E element) {
        return elements.searchElement(element);
    }

    @Override
    public int size() {
        return elements.getSize();
    }

    @Override
    public void clear() {
        elements = new MyLinkedList();
    }

    @Override
    public boolean equals(MyCollection anotherQueue) {
        if (anotherQueue instanceof MyLinkedQueue) {
            MyLinkedQueue anotherQ = (MyLinkedQueue) anotherQueue;
            return this.elements.equals(anotherQ.elements);
        }
        return false;
    }

    @Override
    public void printIt() {
        if (!isEmpty()) {
            System.out.println(elements.printList());
            return;
        }
        System.out.println("Queue is empty.");
    }

    private MyLinkedList elements;
    private int size = 0;

}
