import edu.princeton.cs.algs4.In;

import java.util.Iterator;


public class Permutation {
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);
        String fileName = args[2];
        In fileInput = new In(fileName);
        RandomizedQueue<String> newQueue = new RandomizedQueue<>();
        while (!fileInput.isEmpty())
        {
            newQueue.enqueue(fileInput.readString());
        }
        fileInput.close();

        for (int i=0; i<k;i++)
        {
            System.out.print(newQueue.dequeue()+" ");
        }

    }
}
