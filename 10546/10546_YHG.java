import java.io.*;
import java.util.*;

public class Problem_10546 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
		String tmp;
		
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			if(!ht.isEmpty() && ht.containsKey(tmp)) {
				int s = ht.get(tmp);
				ht.put(tmp, s+1);
			}
			else
				ht.put(tmp,1);
		}
		
		for(int i = 0 ; i < N-1 ; i++) {
			tmp = br.readLine();
			if(ht.get(tmp) == 1)
				ht.remove(tmp, 1);
			else if(ht.get(tmp) > 1) {
				int s = ht.get(tmp);
				ht.put(tmp, s-1);
			}
		}
		
		Iterator mapIt = ht.keySet().iterator();
		while(mapIt.hasNext())
			System.out.println(mapIt.next());
	}
}