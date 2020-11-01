using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System;

public class Solution {

    private int SortFunc( (int,int) x, (int,int) y )
    {
        return 0;
    }
    public int solution(int[,] jobs) {


        int answer = 0;
        List<(int,int)> sortque = new List<(int, int)>(jobs.Length);
        
        for(int i = 0; i < jobs.GetLength(0); ++i)
        {
            sortque.Add( (jobs[i,0], jobs[i,1]) );
        }

        var jobque = sortque.OrderBy((x)=>{            
            return x.Item1;
        }).ThenBy((x2)=>{
            return x2.Item2;
        }).ToList();

        var procQue = new PriorityQueue<ProcData>();
        int currentTime = 0;
        var last_cnt = jobque.Count() - 1;
        int index = 0;

        do{
            // do proc
            if(procQue.Count > 0)
            {  
                // for answer
                var pj = procQue.Dequeue();
                var time_to_proc_from_req = currentTime + pj.procTime - pj.req;
                answer += time_to_proc_from_req;
                currentTime += pj.procTime;
            }

            for(; index < jobque.Count(); ++index)
            {
                var j = jobque[index];
                if(j.Item1 <= currentTime)
                {
                    procQue.Enqueue( new ProcData(j));
                }
                else{
                    if(procQue.Count == 0)
                    {

                        currentTime = j.Item1;
                        procQue.Enqueue(new ProcData(j));
                        ++index;
                    }
                    break;
                }
            }


        }while(sortque.Count() > index || procQue.Count > 0);    

        
        return answer / jobs.GetLength(0);
        
        //작업 시작 시간 0 
        // 3 - 0 = 3
        
        //작업 시작 시간 3
        // 9(작업소요시간) + 3(작업시작시간) - 1(요청시간) = 11
        
        //작업 시작 시간 12
        // 6 + 12 - 2(요청시간) = 16
        
        //요청시간의 길이가 제일 짧은 선택지를 선택해 나아간다.
        
        //검색 현재 선택지 중 다음 요청시간을 짧게 할 수 있는 것은?        
    }
}

public class ProcData : IComparable{
    public int req;
    public int procTime;

    public ProcData((int,int) data)
    {
        req = data.Item1;
        procTime = data.Item2;
    }

    public int CompareTo(object obj)
    {
        var proc2 = obj as ProcData;
        if(proc2 == null)
            return 0;

        if(proc2.procTime > this.procTime)
            return -1;
        else if(proc2.procTime < this.procTime)
            return 1;

        if(proc2.req > this.req)
            return 1;
        
        return -1;
    }
}

class PriorityQueue<T> where T : IComparable
{
    private List<T> list;
    public int Count { get { return list.Count; } }
    public readonly bool IsDescending;

    public PriorityQueue()
    {
        list = new List<T>();
    }

    public PriorityQueue(bool isdesc)
        : this()
    {
        IsDescending = isdesc;
    }

    public PriorityQueue(int capacity)
        : this(capacity, false)
    { }

    public PriorityQueue(IEnumerable<T> collection)
        : this(collection, false)
    { }

    public PriorityQueue(int capacity, bool isdesc)
    {
        list = new List<T>(capacity);
        IsDescending = isdesc;
    }

    public PriorityQueue(IEnumerable<T> collection, bool isdesc)
        : this()
    {
        IsDescending = isdesc;
        foreach (var item in collection)
            Enqueue(item);
    }


    public void Enqueue(T x)
    {
        list.Add(x);
        int i = Count - 1;

        while (i > 0)
        {
            int p = (i - 1) / 2;
            if ((IsDescending ? -1 : 1) * list[p].CompareTo(x) <= 0) break;

            list[i] = list[p];
            i = p;
        }

        if (Count > 0) list[i] = x;
    }

    public T Dequeue()
    {
        T target = Peek();
        T root = list[Count - 1];
        list.RemoveAt(Count - 1);

        int i = 0;
        while (i * 2 + 1 < Count)
        {
            int a = i * 2 + 1;
            int b = i * 2 + 2;
            int c = b < Count && (IsDescending ? -1 : 1) * list[b].CompareTo(list[a]) < 0 ? b : a;

            if ((IsDescending ? -1 : 1) * list[c].CompareTo(root) >= 0) break;
            list[i] = list[c];
            i = c;
        }

        if (Count > 0) list[i] = root;
        return target;
    }

    public T Peek()
    {
        if (Count == 0) throw new InvalidOperationException("Queue is empty.");
        return list[0];
    }

    public void Clear()
    {
        list.Clear();
    }
}