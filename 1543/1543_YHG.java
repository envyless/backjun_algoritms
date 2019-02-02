import java.io.*;

public class Problem_1543 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		int len = insert.length();
		char[] doc = new char[len];
		for(int i = 0 ; i < len ; i++)
			doc[i] = insert.charAt(i);
		
		insert = br.readLine();
		int lenS = insert.length();
		char[] search = new char[lenS];
		for(int i = 0 ; i < lenS ; i++)
			search[i] = insert.charAt(i);
		
		int index = 0;
		int count = 0;
		int max = 0;
		
		for(int i = 0 ; i < len ; i++) {
			index = 0;
			count = 0;
			for(int j = i ; j < len ; j++) {
				if(doc[j] == search[index]) {
					index++;
					if(index == lenS) {
						index = 0;
						count++;
					}
				}
				else {
					if(index != 0)
						j--;
					index = 0;
				}
			}
			if(max < count)
				max = count;
		}
		System.out.println(max);
	}
}