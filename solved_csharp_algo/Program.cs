using System;
using System.Collections.Generic;
using System.Linq;

class Program
{    
    static void Main(string[] args)
    {        
        var s = new Solution();
        
        var a = s.solution(new int[,]
        {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}}
        );
        Console.WriteLine("answer : "+a);
    }
}