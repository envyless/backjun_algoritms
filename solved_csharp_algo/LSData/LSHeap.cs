using System.Collections.Generic;
using System.Collections;
using System;
using System.Linq;

public class LSHeap{
    public List<int> heapDatas = new List<int>();
    public LSHeap(int [] array)
    {                
        heapDatas.AddRange(array);
    }

    private void Add(int data)
    {

    }

    public void HeapifyAll(){
       
    }

    public void Heapify(int cnt){
        //0- 1, 2
        //1- 3,4   / 2 - 5,6
        //3- 7,8   / 4 - 9, 10   / 5- 10,11  / 6 - 12,13

        for(int i = 0; i < cnt; ++i){
            //get child 
            var childIndexs = GetChildIndexs(i);
            var lIndex = childIndexs.Item1;
            var rIndex = childIndexs.Item2;                    

            bool checkAndSwap = CheckAndSwap(i, lIndex);
            checkAndSwap = CheckAndSwap(i, rIndex);

            var parent = (i - 1)/2;
            CheckAndSwap(parent, i);           
        }
    }

    public void HeapifyIndex(int i)
    {
        var childIndexs = GetChildIndexs(i);
        var lIndex = childIndexs.Item1;
        var rIndex = childIndexs.Item2;                    

        bool checkAndSwap = CheckAndSwap(i, lIndex);
        if(checkAndSwap)
        {
            HeapifyIndex(lIndex);
            return;
        }

        checkAndSwap = CheckAndSwap(i, rIndex);
        if(checkAndSwap)
        {
            HeapifyIndex(rIndex);
            return;
        }

        var parent = (i - 1)/2;
        checkAndSwap = CheckAndSwap(parent, i);
        if(checkAndSwap)
        {
            HeapifyIndex(i);
            return;
        }
    }

    private void Draw()
    {
        var h = 0;
        for(int i = 0; i < heapDatas.Count; ++i)
        {
            var currentH = (int)Math.Log2(i+1);            
            if(h != currentH)
            {
                h = currentH;
                Console.WriteLine("");                
            }                        
            WriteTemp(2, heapDatas[i]);
                
        }
    }

    private void WriteTemp(int cnt, int data)
    {
        for(int i = 0; i < cnt; ++i)
        {
            Console.Write(" ");
        }
        Console.Write(data);
        for(int i = 0; i < 2; ++i)
        {
            Console.Write(" ");
        }
    }

    private bool CheckAndSwap(int index, int index2)
    {
        if(index2 < 0 || index < 0)
            return false;

        var value1 = heapDatas[index];
        var value2 = heapDatas[index2];

        bool doSwap = value1 > value2;
        var temp = heapDatas[index2];
        
        if(doSwap)
        {
            heapDatas[index2] = heapDatas[index];
            heapDatas[index] = temp;
        }
        return doSwap;                 
    }

    private (int,int) GetChildIndexs(int index)
    {
        var left = index * 2 + 1;
        var right = left+1;

        if(left >= heapDatas.Count)
            left = -1;
        if(right >= heapDatas.Count)
            right = -1;

        return (left,right);
    }

    public void SortDesc()
    {

    }
}