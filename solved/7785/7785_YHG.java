import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_7785 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			String name = st.nextToken();
			String stat = st.nextToken();
			
			if(stat.equals("enter"))
				hs.add(name);
			else
				hs.remove(name);
		}
		
		ArrayList<String> al = new ArrayList<>(hs);
		Collections.sort(al);
		int size = al.size();
		
		for(int i = size - 1 ; i >= 0 ; i--)
			System.out.println(al.get(i));
	}
}