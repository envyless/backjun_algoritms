using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmSolver
{
    class _1157
    {
        public static void Main(string[] args)
        {
            Dictionary<char, int> char_cnt_map = new Dictionary<char, int>();

            string strs = Console.ReadLine();
            char high_char = Char.ToUpper(strs[0]);
            int hight_score = 0;

            bool isOverraped = false;

            foreach (var ch in strs)
            {
                var ch_upper = Char.ToUpper(ch);

                if (char_cnt_map.ContainsKey(ch_upper))
                    char_cnt_map[ch_upper]++;
                else
                    char_cnt_map.Add(ch_upper, 1);

                // compare
                int score = char_cnt_map[ch_upper];
                if (score > hight_score)
                {
                    isOverraped = false;
                    hight_score = score;
                    high_char = ch_upper;
                }
                else if (score == hight_score)
                {
                    isOverraped = true;
                }
            }
            if (isOverraped)
                high_char = '?';
            Console.Write(high_char);
        }
    }
}
