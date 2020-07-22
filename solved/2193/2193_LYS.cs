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
    static void Main(string[] args)
    {
        //이친수는 0으로 시작하지 않는다.
        //이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
        //N(1≤N≤90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

        // F(N) = F(N-1) + Z(F(N-1))

        // 1 // ofOne[N] = 1
        // 10,  // ofOne[N - 1] + ofZero[N-1] * 2
        // 101, 100,  ofOne[N-1] + ofZero[N-1] * 2
        // 1010, 1000, // 1001  ofOne[N-1] + ofZero[N-1] * 2
        // 10100, 10101, 10001, 10000, ,10010 // 1 + 4/ = 5
        long n = long.Parse(Console.ReadLine());
        long i = 0;
        long[] Zero = new long[n + 1];
        long[] One = new long[n + 1];

        Array.Clear(Zero, 0, (int)n + 1);
        Array.Clear(One, 0, (int)n + 1);
        Zero[0] = 0;
        One[0] = 0;

        Zero[1] = 0;
        One[1] = 1;


        while (i < n)
        {
            Zero[i + 1] += One[i];
            Zero[i + 1] += Zero[i];
            One[i + 1] += Zero[i];
            ++i;
        }
        Console.Write(One[n] + Zero[n]);
        Console.ReadLine();

    }
}
