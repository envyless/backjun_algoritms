import java.io.*;

public class Problem_5582 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert1 = br.readLine();
		String insert2 = br.readLine();
	
		int max = 0;
		int len1 = insert1.length();
		int len2 = insert2.length();
		int[][] value = new int[len1+1][len2+1];
		
		for(int i = 0 ; i < len1 ; i++) {
			for(int j = 0 ; j < len2 ; j++) {
				if(insert1.charAt(i) == insert2.charAt(j))
					value[i+1][j+1] = value[i][j] + 1;
				else
					value[i+1][j+1] = 0;
				
				if(value[i+1][j+1] > max)
					max = value[i+1][j+1];
			}
		}
		System.out.println(max);
	}
}