package com.company.realization;

/**
 * Created by bbr on 08.01.15.
 */
public class MyLinkedList<E> {
    class Link<E> {
        Link next = null;
        E data    = null;
        public Link(E data) {
            this.data = data;
        }
    }

    private Link first = null;
    private int size = 0;
    //private Link last  = null;

    public MyLinkedList() {
        first = null;
    }

    public int getSize() {
        return size;
    }

    public <E> E getFirst() {
        return (E)this.first.data;
    }

    public <E> E getLast() {
        if (!isEmpty()) {
            Link currentLink = first;
            while (currentLink != null) {
                if (currentLink.next == null) {
                    return (E)currentLink.data;
                }
                currentLink = currentLink.next;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public void addFirst(E data) {
        Link newLink = new Link(data);
        newLink.next = null;
        if (this.isEmpty()) {
            first = newLink;
            size++;
        } else {
            newLink.next = first;
            first = newLink;
            size++;
        }
    }

    public void addLast(E data) {
        Link newLink = new Link(data);
        newLink.next = null;
        Link tempLink = first;
        if (this.isEmpty()) {
            first = newLink;
            size++;
        } else {
            while (tempLink != null) {
                if (tempLink.next == null) {
                    tempLink.next = newLink;
                    size++;
                    return;
                }
                tempLink = tempLink.next;
            }
        }
    }

    public boolean equals(MyLinkedList anotherList) {
        boolean result = false;
        if (this.size != anotherList.size) {
            return result;
        }
        Link thisCurrentLink = this.first;
        Link anotherCurrentLink = anotherList.first;
        while (thisCurrentLink != null) {
            if (thisCurrentLink.data.hashCode() != anotherCurrentLink.data.hashCode()) {
                return result;
            }
            thisCurrentLink = thisCurrentLink.next;
            anotherCurrentLink = anotherCurrentLink.next;
        }
        result = true;
        return result;
    }

    public boolean searchElement(E element) {
        boolean result = false;
        if (!isEmpty()) {
            Link currentLink = first;
            while (currentLink != null) {
                if (currentLink.data.hashCode() == element.hashCode()) {
                    result = true;
                    return result;
                }
                currentLink = currentLink.next;
            }
        }
        return result;
    }

    public <E> E deleteFirst() {
        if (!isEmpty()) {
            Link currentLink = new Link(first.data);
            first.data = null;
            first = first.next;
            size--;
            return (E) currentLink.data;
        }
        return null;
    }

    public <E> E deleteLast() {
        if (!isEmpty()) {
            Link currentLink = first;
            Link previousLink = first;
            while (currentLink != null) {
                if (currentLink.next == null) {
                    Link resultLink = new Link(currentLink);
                    previousLink.next = null;
                    //currentLink = null;
                    return (E)resultLink;
                }
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        return null;
    }


    /**
     * Deletes one element if it exists.
     * @param data - Link with this data should be deleted.
     */
    public void deleteLink(E data) {
        Link currentLink = this.first;
        Link previousLink = this.first;
        while (currentLink.next != null) {//|| currentLink.data != data) {
            previousLink = currentLink;
            currentLink = currentLink.next;
            if (currentLink.data == data) {
                previousLink.next = currentLink.next;
                size--;
                return;
            }
            currentLink = currentLink.next;
        }
    }

    public String printList() {
        Link tempLink = this.first;
        String result = "";
        int i = 1;
        while (tempLink != null) {
            //result += " №" + i + ": " + tempLink.data.toString();
            result += tempLink.data.toString() + " ";
            tempLink = tempLink.next;
            i++;
        }
        return result;
    }
    public MyLinkedList catList(MyLinkedList anotherList) {
        Link thisCurrent = first;
        Link anotherCurrent = anotherList.first;
        MyLinkedList resultList;
        if (!this.isEmpty() && !anotherList.isEmpty()) {
            while (thisCurrent != null) {
                if (thisCurrent.next == null) {
                    thisCurrent.next = anotherCurrent;
                    resultList = this;
                    resultList.size = this.size + anotherList.size;
                    return resultList;
                }
                thisCurrent = thisCurrent.next;
            }
        }
        return null;
    }
}