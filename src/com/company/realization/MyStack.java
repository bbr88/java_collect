package com.company.realization;

import com.company.interfaces.MyCollection;
import com.company.interfaces.StackInterface;

import java.lang.reflect.Array;

/**
 * Created by efir758 on 07.01.2015.
 */
public class MyStack<E extends Object> implements StackInterface<E> {

    /**
     *
     * @param aClass
     * @param capacity
     */
    public MyStack(Class<E> aClass, int capacity) {
        //TODO AutoPackage for primitive types. Dunno why, but it doesn't work here(.
        this.EClass = aClass;
        this.elements = (E[])Array.newInstance(EClass, capacity);
        this.size = 0;
    }

    public MyStack(Class<E> aClass) {
        //TODO AutoPackage for primitive types. Dunno why, but it doesn't work here(.
        this.EClass = aClass;
        this.elements = (E[])Array.newInstance(EClass, defaultCapacity);
        this.size = 0;
    }


    /**
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }
    public E getTop() {
        if (this.isEmpty()) {
            return null;
        }
        return this.top;
    }
    public Class getEClass() {
        return this.EClass;
    }

    /**
     *
     * @param n
     */
    private void ensureCapacity(int n) {
        if (elements.length > size + 1) {
            return;
        }
        if (elements.length < size + 1) {
            E[] newElements = (E[])Array.newInstance(EClass, size * 2);
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }


    /**
     *
     * @param element
     */
    @Override
    public void push(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }


    @Override
    public <E> E pop() {
        if (this.isEmpty()) {
            return null;
        }
        System.out.println("Pop:");
        this.size--;
        return (E)this.elements[size];
    }

    @Override
    public <E> E peek() {
        if (this.isEmpty()) {
            return null;
        }
        System.out.println("Peek:");
        return (E)elements[size-1];
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public void clear() {
        if (this.isEmpty()) {
            return;
        }
        this.elements = (E[])new Object[0];
        this.size = 0;
    }

    @Override
    public boolean contains(E element) {
        boolean result = false;
        if (this.isEmpty()) {
            result = false;
        } else {
            for (int i = 0; i < this.size; i++) {

                if (this.elements[i].hashCode() == element.hashCode()) {
                    result = true;
                }
                //System.out.println(elements[i] + " elements");
            }
        }
        return result;
    }

    @Override
    public int size() {
        return this.getSize();
    }

    @Override
    public boolean equals(MyCollection anotherStack) {
        boolean result = true;
        if (anotherStack instanceof StackInterface) {
            MyStack anotherS = (MyStack) anotherStack;
            if (!this.EClass.equals(anotherS.EClass)) {
                result = false;
                //System.out.println("ECLASS.");
            }
            if (this.isEmpty() && anotherS.isEmpty()) {
                result = true;
            } else if (this.size() != anotherS.size) {
                result = false;
                //System.out.println("SIZE!=SIZE");
            } else {
                for (int i = 0; i < this.size(); i++) {
                    if (!this.contains((E) anotherS.elements[i])) {
                        result = false;
                        //System.out.println("ELEMENTS!=ELEMENTS");
                    }
                }
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
        System.out.println("Stack is empty.");
    }

    private int size;
    private Class EClass;
    private E[] elements;
    private E top; //= elements[size];
    private static final int defaultCapacity = 10;
}
