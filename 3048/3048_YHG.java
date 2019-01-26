import java.io.*;
import java.util.StringTokenizer;

public class Problem_3048 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		char[] insert = new char[N1+N2];
		int[] index = new int[N1+N2];
		boolean[] check = new boolean[N1+N2];
		
		int value = N1-1;
		for(int i = N1-1 ; i >= 0 ; i--)
			index[i] = value--;
			
		for(int i = N1 ; i < index.length ; i++)
			index[i] = i;
		
		int sum = 0;
		String tmp, tmp2 = "";
		for(int i = 0 ; i < 2 ; i++) {
			tmp = br.readLine();
			if(i == 0)
				for(int j = tmp.length()-1 ; j >= 0 ; j--)
					tmp2 += tmp.charAt(j);
			else
				tmp2 = tmp;
			for(int j = 0 ; j < tmp2.length(); j++, sum++)
				insert[sum] =  tmp2.charAt(j);
		}
		int time = Integer.parseInt(br.readLine());
		int tmpT = 0;
		
		int max = N1+N2;
		int min = 0;
		while(tmpT < time) {
			for(int i = N1-1 ; i >= N1-1-tmpT ; i--) {
				if(i < 0)
					break;
				if(check[i])
					continue;
				index[i]++;
				if(index[i] == max) {
					check[i] = true;
					index[i] = max-1;
					max--;
				}
			}
			
			for(int i = N1 ; i <= N1+tmpT ; i++) {
				if(i >= N1+N2)
					break;
				if(check[i])
					continue;
				index[i]--;
				if(index[i] == min) {
					check[i] = true;
					index[i] = min;
					min++;
				}
			}
			tmpT++;
		}
		
		for(int i = 0 ; i < N1+N2 ; i++) {
			for(int j = 0 ; j < N1+N2 ; j++)
				if(index[j] == i) {
					System.out.print(insert[j]);
					break;
				}
		}
	}
}