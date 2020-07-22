import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem_1377 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<sort_1377> al = new ArrayList<sort_1377>(N);
		
		for(int i = 0 ; i < N ; i++)
			al.add(new sort_1377(Integer.parseInt(br.readLine()), i));
		
		al.sort(new Comparator<sort_1377>() {
			public int compare(sort_1377 v1, sort_1377 v2) {
				if(v1.num == v2.num)
					return v1.index - v2.index < 0 ? -1 : 1;
				else
					return v1.num - v2.num < 0 ? -1 : 1;
		    }
		});
		
		int max = 0;
		int tmp = 0;
		for(int i = 0 ; i < N ; i++) {
			tmp = al.get(i).index - i + 1;
			if(max < tmp)
				max = tmp;
		}
		System.out.println(max);
	}
}
class sort_1377{
	int num;
	int index;
	
	public sort_1377(int num, int index) {
		this.num = num;
		this.index = index;
	}
}