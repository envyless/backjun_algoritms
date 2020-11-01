using System;
using System.Collections.Generic;
using System.Linq;

class Program
{    
    static void Main(string[] args)
    {        
        var s = new Solution();
        
        var a = s.solution(new int[,]
        {{0, 5}, {1, 2}, {5, 5}}
        );
        Console.WriteLine("answer : "+a);
    }
}