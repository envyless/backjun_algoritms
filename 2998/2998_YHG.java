import java.io.*;

public class Problem_2998 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuffer sb;
		
		String insert = br.readLine();
		int len = 3 - insert.length()%3;
		if(len == 3)
			len = 0;
		sb = new StringBuffer();
		
		for(int i = 0 ; i < len ; i++)
			sb.append("0");
		sb.append(insert);
		String tmp;
		len = sb.length();
		for(int i = 0 ; i < len ; i += 3) {
			tmp = "";
			for(int j = 0 ; j < 3 ; j++)
				tmp += sb.charAt(i+j);
			System.out.print(Integer.parseInt(tmp,2));
		}
	}
}