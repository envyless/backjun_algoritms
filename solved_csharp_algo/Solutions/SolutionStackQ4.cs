using System.Collections.Generic;
using System.Collections;
using System;

public class SolutionStackQ4 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int length = priorities.Length;
        
        Queue<(int,int)> que = new Queue<(int,int)>();
        for(int i = 0; i < length; ++i)
        {
            que.Enqueue((i, priorities[i]));
        }
        
        //인쇄 하느냐 마느냐이다.

        while(que.Count > 0)
        {
            var front = que.Dequeue();            
            bool is_find_bigger_then_front = false;
            


            foreach(var q in que)
            {
                if(front.Item2 < q.Item2)
                {
                    is_find_bigger_then_front = true;
                    break;
                }
            }
            if(is_find_bigger_then_front)
            {
                que.Enqueue(front);
            }
            else{
                //do print
                answer++;
                if(location == front.Item1)
                    break;
            }            
        }

        //1,1,9,1,1,1
        //1,9,1,1,1 1

        //9,1,1,1,1,1
        //9 인쇄 , currentIndex = (1)

        //front queindex == 1
        //current index = queindex - ((총길이 / added 숫자 (1)) * 총길이) 
        

        return answer;
    }
}