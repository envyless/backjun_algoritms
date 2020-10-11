using System;
using System.Collections.Generic;


class Program
{    
    static void Main(string[] args)
    {
        Solution solution = new Solution();
        solution.solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1});
        Console.WriteLine("Hello World!");
    }        
}

/*
bridge_length	weight	truck_weights	answer
1	2	[1, 1, 1]	4
1	1	[1, 1, 1]	4
4	2	[1, 1, 1, 1]	10
3	3	[1, 1, 1]	6
3	1	[1, 1, 1]	10
5	5	[1, 1, 1, 1, 1, 2, 2]	14
7	7	[1, 1, 1, 1, 1, 3, 3]	18
5	5	[1, 1, 1, 1, 1, 2, 2, 2, 2]	19
5	5	[2, 2, 2, 2, 1, 1, 1, 1, 1]
*/

//3
//7
//3,4

//3, 4
//

//0
//1~2 = 7
//3 / 4
//4 / 4, 5
//5 / 5
//6 / 3
//7 / 6
//8 / 


//나혼자 건너가야 되는지 뒤를 쳐다본다.

//1. 혼자 건너간다. 지난시간 += 다리길이
//2. 