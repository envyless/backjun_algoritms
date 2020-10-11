using System;
using System.Collections.Generic;
using System.Numerics;

public class SolutionQ1
{
    public int[] solution(int[] prices)
    {
        List<(int,int)> checklist = new List<(int, int)>(); 

        int[] answer = new int[prices.Length];        
        checklist.Add((0,prices[0]));

        for (int i = 1; i < prices.Length; ++i)
        {
            var after = prices[i];
            // before after check
            for(int k = 0; k < checklist.Count; )
            {
                var check = checklist[k];
                answer[check.Item1]++;
                if (check.Item2 > after)
                {
                    checklist.RemoveAt(k);
                    continue;
                }                
                k++;
            }
            checklist.Add((i, after));
        }

        // 10, 4, 3, 6, 2, 1
        // 1, 1, 
 

        return answer;
    }
}
