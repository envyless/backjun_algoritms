import java.io.*;
import java.util.StringTokenizer;

public class Problem_15686 {
		
	static int N;
	static int M;
	static point_15686[] chi = new point_15686[13];
	static point_15686[] home = new point_15686[100];
	static int indexC = 0;
	static int indexH = 0;
	static int min = 987654;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		int tmp;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N ; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1)
					home[indexH++] = new point_15686(i,j,false);
				else if(tmp == 2)
					chi[indexC++] = new point_15686(i,j,false);
			}
		}
		
		dfs(0,0);
		System.out.println(min);
	}
	
	static public void dfs(int index, int value) {
		
		int sum = 0;
		int len = 100000;
		if(value == M) {
			for(int i = 0 ; i < indexH ; i++) {
				len = 100000;
				for(int j = 0 ; j < indexC ; j++) {
					if(!chi[j].check)
						continue; 
					int tmp = Math.abs(home[i].x - chi[j].x) + Math.abs(home[i].y - chi[j].y);
					if(tmp < len)
						len = tmp;
				}
				sum += len;
			}
			
			if(sum < min)
				min = sum;
		}
		if(index >= indexC)
			return;
		
		chi[index].check = true;
		dfs(index+1, value+1);
		chi[index].check = false;
		dfs(index+1, value);
	}
}
class point_15686{
	int x;
	int y;
	boolean check;
	
	public point_15686(int x, int y, boolean check) {
		this.x = x;
		this.y = y;
		this.check = check;
	}
}