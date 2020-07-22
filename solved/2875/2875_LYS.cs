using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmSolver
{
    class _2875
    {
        public static void Run(string[] args)
        {
            //남자 한명당 여자 2명
            //k명을 뺴라고 할떄 남자 뺴거나 여자 뺴거나 가능,

            //남자 : 여자 == 2 : 1
            //x와 y가 주어졌을때, 

            //2남자가 여자보다 많다.

            //2남자 - 여자 = 나머지
            //15 50
            //30 50
            //-20
            //-20

            //팀이 완성 됬을떄 팀 갯수를 유지하면서 k를 뺴는 방법은 여자에서 부터 제거 하는 것,
            //k가 1~3 까지면 1팀 제거됨, k가 즉 3의 배수면 (k-1)/3 + 1


            string input = Console.ReadLine();
            string[] splited = input.Split(' ');
            long y = long.Parse(splited[0]);
            long x = long.Parse(splited[1]);
            long k = long.Parse(splited[2]);

            long diff = x * 2 - y;

            long dont_need_person = 0;

            long need_men = 0;
            long need_women = 0;

            //남자가 많냐 여자가 많냐
            if (diff >= 0)
            {
                long minus = diff / 2 + diff % 2;
                need_men = x - minus;
                need_women = need_men * 2;
            }
            else
            {
                need_men = x;
                need_women = y + diff;
            }
            //필요없는 애들
            dont_need_person = x - need_men + y - need_women;

            //k 계산
            k = k - dont_need_person;
            if(k > 0)
            {
                //k = 1~3 일때 1, 4~6 일때 2
                long team_cant_join = ((k - 1) / 3 + 1);
                need_men -= team_cant_join;
            }

            Console.WriteLine(need_men);
            Console.ReadLine();
        }
    }
}
