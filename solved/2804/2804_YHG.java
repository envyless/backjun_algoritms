import java.io.*;
import java.util.StringTokenizer;

public class Problem_2804 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		String A = st.nextToken(); // ����
		String B = st.nextToken(); // ����
		int row = -1;
		int cal = -1;
		
		for(int i = 0 ; i < A.length() ; i++) {
			char tmp = A.charAt(i);
			
			for(int j = 0 ; j < B.length() ; j++) {
				if(tmp == B.charAt(j)) {
					row = i; // ���� i ��°�� B�� ����
					cal = j; // ���� j ��°�� A�� ����
					break;
				}
			}
			if(row != -1)
				break;
		}
		
		int index = 0;
		for(int i = 0 ; i < B.length() ; i++) {
			if(cal == i)
				index++;
			for(int j = 0 ; j < A.length() ; j++) {
				if(cal == i)
					System.out.print(A.charAt(j));
				else if(j == row)
					System.out.print(B.charAt(index++));
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}
}