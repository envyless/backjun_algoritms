using System;
using System.CodeDom;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;



namespace ConsoleApplication1
{
    internal class Program
    {
        public class _9012
        {
            public static void Main(string[] args)
            {
                long cnt_loop = long.Parse(Console.ReadLine());
                string [] pss = new string[cnt_loop];
                
                for (int i = 0; i < cnt_loop; i++)
                {
                    pss[i] = Console.ReadLine();
                }
                for (int i = 0; i < cnt_loop; i++)
                {
                    Func(pss[i]);
                }
            }

            public static void Func(string ps)
            {
                long vps_cnt = 0;
                foreach (var ch in ps)
                {
                    if (ch == '(')
                    {
                        vps_cnt++;
                    }
                    else
                    {
                        vps_cnt--;
                        if (vps_cnt < 0)
                        {
                            
                            break;
                        }                        
                    }
                }
                string answer = vps_cnt == 0 ? "YES" : "NO";
                Console.WriteLine(answer);
            }
        }
    }
}
