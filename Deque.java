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
        return null;
    }

    public Item removeLast()
    {   // remove and return the item from the end{}
        return null;
    }

    private class InnerIterator implements Iterator<Item> {
        node startingNode = sentinel.next;
        public boolean hasNext()
        {
            return startingNode != sentinel;
        }

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
    }
    public Iterator<Item> iterator()
    {   // return an iterator over items in order from front to end
        InnerIterator iterator = new InnerIterator();
        return iterator;
    }
    public static void main(String[] args)    // unit testing (optional)
    {
        Deque<Integer> newdeque = new Deque<>();
        newdeque.addFirst(1);
        newdeque.addFirst(2);
        newdeque.addFirst(3);
        newdeque.addFirst(4);

        for(int i: newdeque){
            System.out.print(i+" ");
        }

    }


}