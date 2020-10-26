using System.Collections.Generic;
using System.Collections;
using System;

public class SolutionQ3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {        
        Queue<(int,int)> alist = new Queue<(int,int)>();
        var currentWeight = 0;
        var time = 1;
        for(int i = 0; i < truck_weights.Length; ++i ,time++)
        {
            var truck = truck_weights[i];

            bool isAbleToPath = currentWeight + truck <= weight;
            
            while(!isAbleToPath && alist.Count > 0)
            {
                var first = alist.Dequeue(); // 1, 7        // 3, 4    
                var needtime = (bridge_length - (time - first.Item1)); // 1 - 1 + 2  = 2     //  2(걸리는 시간) - (4 - 3)(걸린 시간)
                if(needtime > 0)
                    time += needtime;

                currentWeight -= first.Item2;                    
                isAbleToPath = currentWeight + truck <= weight;
            }

            if(isAbleToPath)
            {
                currentWeight += truck;
                alist.Enqueue((time, truck)); // 1, 7 ,     // 3, 4   // 4, 5
                
            }  
        }
        if(alist.Count > 0)
        {
            while(alist.Count > 0)
            {
                var first = alist.Dequeue(); // 1, 7        // 3, 4    
                var needtime = (bridge_length - (time - first.Item1)); // 1 - 1 + 2  = 2     //  2(걸리는 시간) - (4 - 3)(걸린 시간)
                if(needtime > 0)
                    time += needtime;
                currentWeight -= first.Item2;                    
                //isAbleToPath = currentWeight + truck <= weight;
            }
        
        }
         
        

        Console.WriteLine("time : "+time);
 
            //첫 트럭 옴
            //7
            //현재 다리 사용 상태, 사용 가능한가?
            //사용 가능 다리에 집어넣음

            //4, 
            //현재 다리 사용 가능?
            //불가능 대기.

            //7 빠져나가기
            //7이 빠져나가고 나면 걸린시간 시점0(0에 들어감)
            //7이 나오고 나면 현재 시점은 bridge_length 만큼 늘어남

            //현재 시간 t = 2
            //4가 들어간 t= t_0 + 1 = 3


            //5는 집어넣을 수 있는가?
            //있음. t = t_4 + 1 = 4
            
            //6을 넣어 보려고 해봄
            //대기
            //대기시 해야하는 일
            //가장 앞에 트럭 뺴기
            //걸린 시간 = 들어간 시점 - 현재 시간 + 길이 = 3 - 4 + 2 = 1
            //현재시간 += 걸린시간

            //6을 넣을 수 있는가?
            //대기
            //대기시 가장 앞인 5를 빼야함.
            //get first(5)
            //4 - 5 + 2 = 1
            //1
            //현재 시간 += 걸린시간

            //6 넣음.

            ///모든 루프가 끝나고, 꺼내기 로직
            //들어간 시점, 6 - 6 + 2 = 2 

        return time;
    }
}