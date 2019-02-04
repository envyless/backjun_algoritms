import java.io.*;

public class Problem_2668 {

	static int insert[], check[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		insert = new int[N];
		check = new int[N];
		for(int i = 0 ; i < N ; i++)
			insert[i] = Integer.parseInt(br.readLine())-1;
		
		for(int i = 0 ; i < N ; i++) {
			dfs(i);
			for(int j = 0 ; j < N ; j++)
				if(check[j] != 2)
					check[j] = 0;
		}
		
		for(int i = 0 ; i < N ; i++)
			if(check[i] == 2)
				count++;
		System.out.println(count);
		for(int i = 0 ; i < N ; i++)
			if(check[i] == 2) {
				System.out.println(i+1);
			}
	}
	
	static public void dfs(int index) {
		if(check[index] == 2)
			return;
		check[index]++;
		dfs(insert[index]);
	}
}