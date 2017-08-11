import java.util.Iterator;
import org.junit.Assert.*;
import org.junit.Test.*;

public class RandomizedQueue<Item> implements Iterable<Item> {
    Item[] hiddenArray;
    int size;
    int pointer;
    private static int initialArraySize = 4;
    public RandomizedQueue()
    {   // construct an empty randomized queue
        hiddenArray = (Item[]) new Object[initialArraySize];
        size = 0;
        pointer = 0; // pointer points to zero at the beginning when there is no element in the array
                     // pointer means the next slot to insert item into
    }

    public boolean isEmpty()
    {  // is the queue empty?
        return size == 0;
    }

    public int size()
    {   // return the number of items on the queue
        return size;
    }

    public void enqueue(Item item)
    {   // add the item
        if (pointer >= hiddenArray.length)
            resize(hiddenArray.length*2);
        hiddenArray[pointer] = item;
        pointer++;
        size++;
    }

    private void resize(int newSize)
    {
        Item[] newArray = (Item[]) new Object[newSize];
        for (int i=0; i< size; i++)
            newArray[i] = hiddenArray[i];
        hiddenArray = newArray;
    }

    public Item dequeue()
    {   // remove and return a random item
        if (size<=0)
            throw new java.util.NoSuchElementException("The queue is empty, cannot dequeue anymore!");
        int index = (int)(size*Math.random());
        Item tempValue = hiddenArray[index];
        hiddenArray[index] = hiddenArray[pointer-1];
        hiddenArray[pointer-1] = null;
        pointer --;
        size --;
        if ( size <= hiddenArray.length/4.0 && size >= initialArraySize)
        {
            resize(size);
        }
        return tempValue;
    }
    public Item sample()
    {   // return (but do not remove) a random item
        if (size<=0)
            throw new java.util.NoSuchElementException("The queue is empty, cannot dequeue anymore!");
        int index = (int)(size*Math.random());
        Item tempValue = hiddenArray[index];
        return tempValue;
    }

    public Iterator<Item> iterator()
    {   // return an independent iterator over items in random order
        IteratorClass<Item> iterator = new IteratorClass<>();
        return iterator;
    }

    public class IteratorClass<Item> implements Iterator<Item> {
        Item[] iteratorArray;
        int sizeCount =size;
        public IteratorClass()
        {
            int tempSize = size;
            iteratorArray = (Item[]) new Object[size];
            Item[] tempArray = (Item[]) new Object[size];
            for (int i=0; i< size; i++)
            {
                tempArray[i] = (Item)hiddenArray[i];
            }

            for (int i=0; i < size; i++)
            {
                int index = (int)(Math.random()*tempSize);
                iteratorArray[i] = tempArray[index];
                tempArray[index] = (Item)tempArray[tempSize-1];
                tempSize--;
            }

        }

        @Override
        public boolean hasNext()
        {
            return sizeCount>0;
        }
        @Override

        public Item next(){
            if (!hasNext())
                throw new java.util.NoSuchElementException("Sorry the queue is already empty");
            else
            {
                sizeCount--;
                return iteratorArray[sizeCount];
            }
            //java.util.NoSuchElementException;
        }
    }

    public static void main(String[] args)
    {   // unit testing (optional)
        RandomizedQueue<Integer> newQueue = new RandomizedQueue<>();
        for (int i=0; i<20; i++)
            newQueue.enqueue(i);
        Iterator<Integer> newIterator = newQueue.iterator();

        while(newIterator.hasNext())
            System.out.println(newIterator.next());

    }




}