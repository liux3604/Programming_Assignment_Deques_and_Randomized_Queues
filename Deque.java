/**
 * I will implment deque using doubly linked list and using a circular sentinel structure
 */

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private node sentinel;
    private int size;
    public Deque()
    {   // construct an empty deque
        sentinel = new node (null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    private class node
    {   //private inner class
        Item value;
        node next;
        node prev;
        node (Item value){
            this.value = value;
        }
    }

    public boolean isEmpty() {  return size == 0; }                // is the deque empty?{}
    public int size() { return size; }                    // return the number of items on the deque{}
    public void addLast(Item item)   // add the item to the front{}
    {
        if (item == null)
            throw new java.lang.IllegalArgumentException("cannot add null to the deque.");
        else
        {
            node newNode = new node(item);
            newNode.next = sentinel;
            newNode.prev = sentinel.prev;
            sentinel.prev.next = newNode;
            sentinel.prev = newNode;
            size++;
        }

    }
    public void addFirst(Item item)
    {
        if (item == null)
        {
            throw new java.lang.IllegalArgumentException("Cannot add a null item into this deque!");
        }
        else
        {
            node newNode = new node(item);
            newNode.prev = sentinel;
            newNode.next = sentinel.next;
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
            size++;
        }

    }

    public Item removeFirst()
    {   // remove and return the item from the front{}
        if (size == 0)
            throw new java.util.NoSuchElementException("the deque is empty, nothing to remove");
        else
        {
            Item tempValue = sentinel.next.value;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return tempValue;


        }
    }

    public Item removeLast()
    {   // remove and return the item from the end{}
        if (size == 0)
            throw new java.util.NoSuchElementException("the deque is empty, nothing to remove");
        else
        {
            Item tempValue = sentinel.prev.value;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return tempValue;
        }
    }

    private class InnerIterator implements Iterator<Item> {
        node startingNode = sentinel.next;

        @Override
        public boolean hasNext()
        {
            return startingNode != sentinel;
        }

        @Override
        public Item next()
        {
            if (!hasNext())
                throw new java.util.NoSuchElementException("No more element left in the deque!");
            else
            {
                Item temValue = startingNode.value;
                startingNode = startingNode.next;
                return temValue;
            }
        }
        @Override
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException("This operation is not supported here.");
        }
    }
    public Iterator<Item> iterator()
    {   // return an iterator over items in order from front to end
        InnerIterator iterator = new InnerIterator();
        return iterator;
    }
    public static void main(String[] args)    // unit testing (optional)
    {
        Deque<Integer> newdeque = new Deque<>();
        newdeque.addLast(1);
        newdeque.addLast(2);
        newdeque.addLast(3);
        newdeque.addLast(4);
        newdeque.removeLast();
        newdeque.addLast(1);
        newdeque.addLast(2);
        newdeque.addLast(3);
        newdeque.addLast(4);
        for(int i: newdeque){
            System.out.print(i+" ");
        }
    }


}