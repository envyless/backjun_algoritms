import java.io.*;
import java.util.StringTokenizer;

public class Problem_1969 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 갯수
		int M = Integer.parseInt(st.nextToken()); // 길이
		
		int[][] alpha = new int[M][4]; // A,C,G,T 순서.
		
		String tmp;
		char save;
		for(int i = 0 ; i < N ; i++) {
			tmp = br.readLine();
			
			for(int j = 0 ; j < M ; j++) {
				save = tmp.charAt(j);
				switch(save) {
				case 'A':
					alpha[j][0]++;
					break;
				case 'C':
					alpha[j][1]++;
					break;
				case 'G':
					alpha[j][2]++;
					break;
				case 'T':
					alpha[j][3]++;
					break;
				}
			}
		}
		
		int count = 0;
		String result = "";
		int index,max;
		for(int i = 0 ; i < M ; i++) {
			index = 0;
			max = alpha[i][0];
			count += alpha[i][0];
			for(int j = 1 ; j < 4 ; j++) {
				count += alpha[i][j];
				if(max < alpha[i][j]) {
					max = alpha[i][j];
					index = j;
				}
			}
			count -= max;
			
			switch(index) {
			case 0:
				result += 'A';
				break;
			case 1:
				result += 'C';
				break;
			case 2:
				result += 'G';
				break;
			case 3:
				result += 'T';
				break;
			}
		}
		System.out.println(result);
		System.out.println(count);
	}
}