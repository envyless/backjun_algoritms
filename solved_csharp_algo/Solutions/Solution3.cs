using System;
using System.Collections.Generic;

public class Solution34 {

    public void DFS(string root, string key, List<string> keys, Dictionary<string, int> cached, int start)
    {   
        var last = keys.Count;
        if(start >= last)
            return;        

        var hashkey = root + key;        
        bool isOriginkey = keys.Contains(key);
        if(!isOriginkey)
        {
            if(cached.ContainsKey(hashkey))
                return;        
            if(hashkey != "")
            {
                                
            }            
        }
        
             
        Console.WriteLine("root : "+hashkey);
        var rootvalue = 1;        
        if(cached.ContainsKey(root))
            rootvalue = cached[root];
        if(!cached.ContainsKey(hashkey) && key != "")    
            cached.Add(hashkey, rootvalue * cached[key]);
        
        root = hashkey; 
        
        for(int i = start; i < last; ++i)
        {
            var findkey = keys[i];
            DFS(root, findkey, keys, cached, i+1);            
        }     
    }
    public int solution(string[,] clothes) {
        int answer = 0;
        Dictionary<string, int> dictCount = new Dictionary<string, int>();
        /*var cnt = clothes.Length / 2;
        for(int i = 0; i < cnt; ++i)
        {
            var kind = clothes[i,1];
            if(!dictCount.TryGetValue(kind, out var count))
            {
                dictCount.Add(kind, 0);
            }
            dictCount[kind]++;
        }*/

        //갯수들의 곱
        //갯수의 총 합
        dictCount.Add("head", 3);
        //dictCount.Add("eye", 1);
        
        var keys = new List<string>(dictCount.Keys);
        DFS("", "", keys, dictCount, 0);
        foreach(var h in dictCount)
        {
            answer += h.Value;
        }

        //Console.WriteLine("an : "+answer);
        //저건 다 하나씩은 입는다는 전제고
        //1개만 입을 수 도,
        //2개만 입을 수 도,        
        // a,b  a,c  a,d  b,c  b,d  c,d
        // a,b,c  a,b,d  a,c,d  b,c,d
        // a,b,c,d
        // a  b  c  d
        // 4개중 3개 고르는 건가본데

        return answer;
    }

    void FindWithAdd(string kind, string name,Dictionary<string, int> clothes, Dictionary<string, int> cached)
    {
                
    }
}