package com.company;

import com.company.interfaces.MyCollection;
import com.company.realization.*;

public class Main {

    public static void main(String[] args) {
	/*  ----------------------------------------------------------
                            ArrayStack tests
        ----------------------------------------------------------
    */
        System.out.println("ArrayStack tests\n");

        MyStack<String> myStack = new MyStack<String>(String.class, 10);
        MyStack<String> myStack1 = new MyStack<String>(String.class);
        MyStack<Integer> myStack2 = new MyStack<Integer>(Integer.class);
        MyStack<Object> myStack3 = new MyStack<Object>(Object.class);

        myStack.push("asd");
        myStack.push("asddd");
        myStack.push("aqweqr");

        myStack1.push("asd");
        myStack1.push("asddd");
        myStack1.push("aqweqr");

        myStack.printIt();
        System.out.println("Size = " + myStack.getSize());
        System.out.println("Its not empty! " + !myStack.isEmpty());
        System.out.println("Does it contains \"asddd\"? " + myStack.contains("asddd"));


        System.out.println("MyStack equals myStack1? " + myStack.equals(myStack1));
        System.out.println("MyStack equals myStack3" + myStack.equals(myStack3));
        System.out.println("\n");


	/*  ----------------------------------------------------------
                            ArrayQueue tests
        ----------------------------------------------------------
    */
        System.out.println("ArrayQueue tests\n");

        MyQueue<String> myQueue = new MyQueue<String>(String.class, 3);
        MyQueue<String> myAnotherQueue = new MyQueue<String>(String.class, 5);
        MyQueue<Integer> myQueue1 = new MyQueue<Integer>(Integer.class, 15);

        myQueue.pushLast("qwe");
        myQueue.pushLast(12+"");
        myQueue.pushLast("asd");
        //myQueue.pushLast("oneMore");
        //myQueue1.pushLast(12);

        myAnotherQueue.pushLast("qwe");
        myAnotherQueue.pushLast(12+"");
        myAnotherQueue.pushLast("asd");


        System.out.println("If these queues are equal? " + myQueue.equals(myAnotherQueue));
        System.out.println("Peek test, the first one item is: " + myQueue.peekFirst());
        System.out.println("Is it full? " + myQueue.isFull());
        System.out.println(myQueue.getSize());
        //myQueue.clear();
        System.out.println("Does it contains \"asd\"? " + myQueue.contains("asd"));
        System.out.println("Item popped : " + myQueue.popFirst());
        System.out.println("Item popped : " + myQueue.popFirst());
        myQueue.popFirst();

        //myQueue.popFirst();
        System.out.println("Is it empty? - " + myQueue.isEmpty());
        System.out.println("MaxSize = " + myQueue.getMaxSize() + "; Current size = " + myQueue.getSize());
        System.out.println("\n");


    /*  ----------------------------------------------------------
                            LinkStack tests
        ----------------------------------------------------------
    */
        System.out.println("LinkStack tests\n");

        MyLinkedList list = new MyLinkedList();
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedListStack myLinkedListStack = new MyLinkedListStack();
        MyLinkedListStack myLinkedListStack1 = new MyLinkedListStack();
        myLinkedListStack.push(12345);
        myLinkedListStack.push("asd");
        myLinkedListStack.push("another element");


        myLinkedListStack1.push(12345);
        myLinkedListStack1.push("asd");
        myLinkedListStack1.push("another element");

        System.out.println("If these Stacks are equal? " + myLinkedListStack.equals(myLinkedListStack1));
        System.out.println("Stack size : " + myLinkedListStack.getSize());
        System.out.println("Pop : " + myLinkedListStack.pop());
        System.out.println("Peek : " + myLinkedListStack.peek());
        System.out.println("Does it contains \"asd\"? " + myLinkedListStack.contains("asd"));
        System.out.println("Is it empty? " + myLinkedListStack1.isEmpty());
        myLinkedListStack1.clear();
        System.out.println("Empty now! " + myLinkedListStack1.isEmpty());
        System.out.println("\n");


    /*  ----------------------------------------------------------
                            LinkQueue tests
        ----------------------------------------------------------
    */
        System.out.println("LinkQueue tests\n");

        MyLinkedQueue myLinkedQueue = new MyLinkedQueue();
        MyLinkedQueue myLinkedQueue1 = new MyLinkedQueue();
        myLinkedQueue.pushLast("asd");
        myLinkedQueue.pushLast(321);

        myLinkedQueue1.pushLast("asd");
        myLinkedQueue1.pushLast(321);


        System.out.println("If these queues are equal? " + myLinkedQueue.equals(myLinkedQueue1));
        System.out.println("Size = " + myLinkedQueue.size());
        myLinkedQueue.clear();
        System.out.println("Cleared? " + myLinkedQueue.isEmpty());
        System.out.println("\n");

    /*  ----------------------------------------------------------
                            LinkDeq tests
        ----------------------------------------------------------
    */


        System.out.println("LinkDeq tests\n");

        MyLinkedDeq myLinkedDeq = new MyLinkedDeq();
        MyCollection myLinkedDeq1 = new MyLinkedDeq();

        myLinkedDeq.pushFirst("first");
        myLinkedDeq.pushFirst("qweasd");
        myLinkedDeq.pushLast("last");
        myLinkedDeq.pushLast(12345);

        ((MyLinkedDeq)myLinkedDeq1).pushFirst("first");
        ((MyLinkedDeq)myLinkedDeq1).pushFirst("qweasd");
        ((MyLinkedDeq)myLinkedDeq1).pushLast("last");
        ((MyLinkedDeq)myLinkedDeq1).pushLast(12345);

        myLinkedDeq.printIt();
        System.out.println("Its size = " + myLinkedDeq.size());
        System.out.println("Does it contains \"last\"? " + myLinkedDeq.contains("last"));
        System.out.println("First : " + myLinkedDeq.peekFirst() + ", Last " + myLinkedDeq.peekLast());
        System.out.println("It's not empty! " + !myLinkedDeq.isEmpty());
        myLinkedDeq.clear();
        System.out.println("It's empty! " + myLinkedDeq.isEmpty());
    }
}
