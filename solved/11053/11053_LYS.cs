using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution
{
    static long[] answer;
    static long[] nums;
    static void Main(string[] args)
    {
        long n = long.Parse(Console.ReadLine());

        string input = Console.ReadLine();
        string[] splited = input.Split(' ');
        answer = new long[n + 1];
        nums = new long[n + 1];
        Array.Clear(answer, 0, (int)(n + 1));

        for (int i=0; i < splited.Length; ++i)
        {
            nums[i] = long.Parse(splited[i]);
        }
        
        long max = 1;


        // 11, 10, 20, 12, 13, 30, 15, 40,16, 50, 1000, 1001, 1002, 1003
        // a[1] = 1
        // a[2] = n[2] > n[1] ? a[1] + 1 : find( smaller than me and a[x] + 1 )
        // a[3] = n[3] > n[1] ? a[1] + 1 : find( smaller than me and a[x] + 1 )
        answer[0] = 1;
        for (int i = 1; i < n; ++i)
        {
            answer[i] = FindSmallerThanMe(nums[i], i - 1) + 1;
            if (answer[i] > max)
                max = answer[i];
        }
        Console.Write(max);
        Console.ReadLine();
    }

    private static long FindSmallerThanMe(long num, int index)
    {
        long max = 0;
        for(int i = index; i >= 0; --i)
        {
            if(nums[i] < num)
            {
                if(max < answer[i])
                {
                    max = answer[i];
                }
            }
        }
        return max;
    }
}
