package com.company.realization;

import com.company.interfaces.MyCollection;
import com.company.interfaces.QueueInterface;

import java.lang.reflect.Array;

/**
 * Created by bbr on 08.01.15.
 */
public class MyQueue<E extends Object> implements QueueInterface<E> {

    public MyQueue(Class<E> EClass) {
        //TODO AutoPackage for primitive types. Dunno why, but it doesn't work here(.
        this.EClass = EClass;
        this.maxSize = defaultCapacity;
        this.elements = (E[])Array.newInstance(EClass, maxSize);
    }

    public MyQueue(Class<E> EClass, int maxSize) {
        //TODO AutoPackage for primitive types. Dunno why, but it doesn't work here(.
        this.EClass = EClass;
        this.maxSize = maxSize + 1;
        this.elements = (E[])Array.newInstance(EClass, this.maxSize);
        //this.first = 0;
        //this.last = -1;

    }

    public int getMaxSize() {
        return this.maxSize - 1;
    }
    public int getSize() {
        return this.size;
    }

    @Override
    public void pushLast(E element) {
        if (!isFull()) {
            if (last == maxSize - 1) { //циклический перенос
                last = -1;
            }
            //System.out.println("LAST == " + last);
            if (last == 0) {
                elements[last++] = element;
                size++;
                //System.out.println("Pushed : " + elements[last-1] + " Index (0): " + (last-1));
                return;
            }
            if (last == -1) {
                elements[++last] = element;
                //System.out.println("Pushed : " + elements[last] + " Index (-1): " + (last));
                size++;
            } else {
                elements[last++] = element;
                //System.out.println("Pushed : " + elements[last-1] + " Index (other): " + (last-1));
                size++;
            }
        } else {
            System.out.println("Queue is full.");
        }
    }

    @Override
    public <E> E popFirst() {
        if (size > 0) {
            E temp = (E)elements[first];
            //System.out.println("TESTTEST == " + temp + "  " + first);
            elements[first++] = null;
            if (first == maxSize) {
                first = 0;
            }
            size--;
            return temp;
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        if (elements.length == 0) {
            result = true;
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null) {
                    //System.out.println("Element " + i + " = " + elements[i]);
                    result = false;
                }
            }
        }
        return result;
    }

    //+@Override
    public boolean isFull() {
        boolean result = false;
        if (isEmpty()) {
            result = false;
        }
        if (size == maxSize - 1) {
            result = true;
        }
        return result;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            for (int i = 0; i < elements.length; i++) {
                elements[i] = null;
            }
            this.maxSize = defaultCapacity;
            return;
        }
        System.out.println("Queue is empty.");

    }

    @Override
    public boolean contains(E element) {
        boolean result = false;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                System.out.println("Element number" + i + " = " + elements[i]);
                if (elements[i].hashCode() == element.hashCode()) {
                    result = true;
                }
            }
        }

        return result;
    }

    @Override
    public int size() {
        return this.getSize();
    }

    @Override
    public boolean equals(MyCollection anotherQueue) {
        boolean result = true;
        if (anotherQueue instanceof MyQueue) {
            MyQueue anotherQ = (MyQueue) anotherQueue;
            if (isEmpty() && anotherQ.isEmpty()) {
                System.out.println("Both queues are empty.");
                result = true;
            }
            if (isEmpty() || anotherQ.isEmpty()) {
                result = false;
                return result;
            }
            if (this.size == anotherQ.size) {
                E[] tempElements = (E[]) Array.newInstance(EClass, size);
                E[] tempAnotherElements = (E[]) Array.newInstance(anotherQ.EClass, anotherQ.size);
                int j = 0;
                int k = 0;
                for (int i = 0; i < elements.length; i++) {
                    if (elements[i] != null) {
                        tempElements[j++] = elements[i];
                    }

                }
                for (int i = 0; i < anotherQ.elements.length; i++) {
                    if (anotherQ.elements[i] != null) {
                        tempAnotherElements[k++] = (E) anotherQ.elements[i];
                    }
                }
                for (int i = 0; i < size; i++) {
                    if (tempElements[i].hashCode() != tempAnotherElements[i].hashCode()) {
                        result = false;
                    }
                }
            /*for (int i = 0; i < (elements.length > anotherQueue.elements.length ? elements.length : anotherQueue.elements.length); i++) {
                if (this.elements[i].hashCode() != anotherQueue.elements[i].hashCode()) {
                    result = false;
                }
            } */
            }
            return result;
        }
        return false;
    }

    @Override
    public void printIt() {
        if (!isEmpty()) {
            for (int i = 0; i < elements.length; i++) {
                System.out.print(elements[i] + " ");
            }
            return;
        }
        System.out.println("Queue is empty.");
    }


    @Override
    public <E> E peekFirst() {
        return (E)elements[first];
    }
    private static final int defaultCapacity = 10;
    private int maxSize                      = 0;
    private int size                         = 0;
    private int first                        = 0;
    private int last                         = 0;
    private E[] elements                     = null;
    private Class EClass                     = null;
}
