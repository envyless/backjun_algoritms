import java.io.*;
import java.util.Stack;

public class Problem_1935 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine()); // 피연산자 갯수
		int[] value = new int[N];
		
		String insert = br.readLine(); // 후위표현식
		for(int i = 0 ; i < N ; i++)
			value[i] = Integer.parseInt(br.readLine()); // 각 연산자 값
		
		// 연산자는 + - * / 
		double result = 0.0;
		Stack<Double> st = new Stack<Double>();
		
		char tmp;
		double v1,v2;
		for(int i = 0 ; i < insert.length() ; i++) {
			tmp = insert.charAt(i);
			if(tmp >= 'A' && tmp <= 'Z') 
				st.push((double)value[tmp - 'A']);
			else
				if(tmp == '*') {
					v1 = st.pop();
					v2 = st.pop();
					result = v2 * v1;
					st.push(result);
				}
				else if(tmp == '/') {
					v1 = st.pop();
					v2 = st.pop();
					result = v2 / v1;
					st.push(result);
				}
				else if(tmp == '+') {
					v1 = st.pop();
					v2 = st.pop();
					result = v2 + v1;
					st.push(result);
				}
				else if(tmp == '-') {
					v1 = st.pop();
					v2 = st.pop();
					result = v2 - v1;
					st.push(result);
				}
		}
		System.out.println(String.format("%.2f", st.pop()));
	}
}