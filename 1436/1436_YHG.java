import java.io.*;

public class Problem_1436 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine()); // 666 ~ 9666
		int[] insert = new int[N+1];
		
		int value = 1666;
		insert[0] = 666;
		int index = 1;
		String tmp;
		while(index < N) {
			tmp = String.valueOf(value);
			if(tmp.contains("666"))
				insert[index++] = value;
			value++;
		}
		System.out.println(insert[N-1]);
	}
}