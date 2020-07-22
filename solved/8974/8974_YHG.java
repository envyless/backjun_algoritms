import java.io.*;
import java.util.StringTokenizer;

public class Problem_8974 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[B+3];
		int index = 1;
		for(int i = 1 ; index <= B ; i++)
			for(int j = 1 ; j <= i ; j++)
				if(index <= B)
					arr[index++] = i;
		
		int sum = 0;
		for(int i = A ; i <= B ; i++)
			sum += arr[i];
		System.out.println(sum);
	}
}