using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmSolver
{
    public class _2839
    {
        public static void Run(string[] args)
        {
            //3과
            //5의 설탕 봉지

            long n = long.Parse(Console.ReadLine());
            long moc3_added = 0;
            while(true)
            {
                long moc = n / 5;
                long namoge = n % 5;

                bool isAbleAnswer = namoge % 3 == 0;

                if(isAbleAnswer)
                {
                    long moc3 = namoge / 3;                                        
                    Console.WriteLine(moc + moc3 + moc3_added);
                    Console.ReadLine();
                    return;
                }
                n -= 3;
                moc3_added++;

                if(n < 0)
                {
                    break;
                }
            }

            Console.WriteLine(-1);
            Console.ReadLine();

            //kg_5_cnt = (n / 15) * 3;
            //if(kg_5_cnt == 0)
            //{
            //    kg_5_cnt = (n / 5);
            //}

            //long left = n % 15;

            //if (left >= 3)
            //{
            //    if (0 == left % 3)
            //    {
            //        kg_3_cnt = left / 3;
            //        Console.WriteLine(kg_5_cnt + kg_3_cnt);
            //        Console.ReadLine();
            //    }
            //    else
            //    {
            //        Console.WriteLine(-1);
            //        Console.ReadLine();
            //    }
            //}
        }
    }
}
