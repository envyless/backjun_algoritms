using System.Collections.Generic;
using System.Linq;
using System;

class SelectSample1
{
    static void MainTest()
    {
        //Create the data source
        List<(int, int)> Scores = new List<(int, int)>();
        var range = Enumerable.Range(1, 10);
        var rand = new Random();
        foreach(var a in range)
        {
            Scores.Add((a, rand.Next(0,100)));
        }
        
        var before = 0;
        var quary = from score in Scores where score.Item2 > before select(
            (score, score.Item1)
            );    
        // Create the query.
        // IEnumerable<int> queryHighScores = from a in Scores where a > 80 select a;
            

        // // Execute the query. 
        // foreach (int i in queryHighScores)
        // {
        //     Console.Write(i + " ");
        // }
    }
}