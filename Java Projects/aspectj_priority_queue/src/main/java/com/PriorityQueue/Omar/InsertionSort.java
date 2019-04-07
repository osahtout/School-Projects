package com.PriorityQueue.Omar;

public class InsertionSort {

    public static int[] insertionSort(int[] toSort)
    {

        for (int i = 1;i < toSort.length; i++)
        {

            int index = toSort[i];
            int k = i;


            while((k-1)>=0 && toSort[k-1]>index)
            {
                for (int j = 0;j < toSort.length; j++)
                {
                    System.out.print(toSort[j]+" ");
                }
                System.out.println("");
                toSort[k] = toSort[k-1];
                k--;

            }

            toSort[k] = index;
        }



        return toSort;



    }


}
