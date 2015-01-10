package com.company.realization;

import com.company.interfaces.DeqInterface;
import com.company.interfaces.MyCollection;

/**
 * Created by bbr on 08.01.15.
 */
public class MyLinkedDeq<E> implements DeqInterface<E> {

    @Override
    public void pushFirst(E element) {
        size++;
        elements.addFirst(element);
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
    public <E> E popLast() {
        size--;
        return (E)elements.deleteLast();
    }

    @Override
    public <E> E peekFirst() {
        return (E)elements.getFirst();
    }

    @Override
    public <E> E peekLast() {
        return (E)elements.getLast();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void clear() {
        elements = new MyLinkedList();
    }

    @Override
    public int size() {
        return elements.getSize();
    }

    @Override
    public boolean contains(E element) {
        if (isEmpty()) {
            return false;
        }
        return elements.searchElement(element);
    }

    @Override
    public boolean equals(MyCollection anotherDeq) {
        boolean result = false;
        if (anotherDeq instanceof MyLinkedDeq) {
            MyLinkedDeq anotherD = (MyLinkedDeq) anotherDeq;
            return elements.equals(anotherD.elements);
        }
        return result;
    }

    @Override
    public void printIt() {
        if (!isEmpty()) {
            System.out.println(elements.printList());
            return;
        }
        System.out.println("Deq is empty.");
    }

    public MyLinkedDeq() {
        this.size = 0;
        this.elements = new MyLinkedList();
    }

    private MyLinkedList elements = null;
    private int size              = 0;

}
