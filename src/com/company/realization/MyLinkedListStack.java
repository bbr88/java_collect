package com.company.realization;

import com.company.interfaces.MyCollection;
import com.company.interfaces.StackInterface;

/**
 * Created by bbr on 08.01.15.
 */
public class MyLinkedListStack<E> implements StackInterface<E> {


    public MyLinkedListStack() {
        //this.EClass = EClass;
        this.elements = new MyLinkedList();
        this.size = this.elements.getSize();
    }

    @Override
    public void push(E element) {
        elements.addFirst(element);
        size++;
    }

    @Override
    public <E> E pop() {
        size--;
        return (E)elements.deleteFirst();
    }

    @Override
    public <E> E peek() {
        return (E)elements.getFirst();
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
        return size;
    }

    @Override
    public boolean contains(E element) {
        return elements.searchElement(element);
    }

    @Override
    public boolean equals(MyCollection anotherStack) {
        if (anotherStack instanceof MyLinkedListStack) {
            MyLinkedListStack anotherS = (MyLinkedListStack) anotherStack;
            return elements.equals(anotherS.elements);
        }
        return false;
    }


    @Override
    public void printIt() {
        if (!isEmpty()) {
            System.out.println(elements.printList());
            return;
        }
        System.out.println("Stack is empty.");
    }

    public int getSize() {
        return this.size;
    }


    private MyLinkedList elements = null;
    private int size = 0;
    //private Class EClass = null;
    //private static final int defaultCapacity = 10;

}
