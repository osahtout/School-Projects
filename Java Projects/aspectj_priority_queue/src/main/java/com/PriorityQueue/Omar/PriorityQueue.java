package com.PriorityQueue.Omar;

import org.aspectj.lang.annotation.Aspect;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Iterator;

@Aspect
public class PriorityQueue<el> implements Comparable<el>{

    private static int sizeOfQueue = 0;
    private int maxSizeOfQueue, frontOfQueue, backOfQueue, key;

    private el[] queueArray;
    private el elementType;


    public PriorityQueue(int maxSizeOfQueue)
    {
        this.maxSizeOfQueue = maxSizeOfQueue;
      //  this.queueArray = new el[maxSizeOfQueue];
    }

    public boolean add(el elementType, int key)
    {


        return false;
    }


    public boolean isFull()
    {
        if(sizeOfQueue + 1 == sizeOfQueue)
            return true;
        else
            return false;
    }

    public boolean isEmpty()
    {
        if(sizeOfQueue == 0 || backOfQueue == 0)
            return true;

        return false;
    }


    public static int[] sort(int[] toSort)
    {
        for (int i = 1;i < toSort.length; i++)
        {
            int index = toSort[i];
            int k = i;

            while((k-1)>=0 && toSort[k-1]>index)
            {
                for (int i1 : toSort) System.out.print(i1 + " ");

                System.out.println();
                toSort[k] = toSort[k-1];
                k--;

            }

            toSort[k] = index;
        }

        return toSort;



    }

    @Override
    public int compareTo(el el) {
        return 0;
    }
}
