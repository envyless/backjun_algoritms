import java.io.*;

public class Problem_9935 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String insert = br.readLine();
		String bomb = br.readLine();
		char[] result = new char[1000000];
		int len = insert.length();
		int lenB = bomb.length();
		
		for(int i = 0 ; i < lenB-1 ; i++)
			result[i] = insert.charAt(i);
		int index = lenB-1;
		int indexR = index;
		
		char tmp;
		String check;
		while(index < len) {
			check = "";
			tmp = insert.charAt(index);
			result[indexR++] = tmp;
			if(indexR >= lenB && result[indexR-1] == bomb.charAt(lenB-1))
				if(result[indexR-lenB] == bomb.charAt(0)) {
					for(int i = 0 ; i < lenB ; i++)
						check += result[indexR-lenB+i];
					if(check.equals(bomb))
						indexR = indexR-lenB;
				}
			index++;
		}
		
		if(indexR == 0)
			System.out.println("FRULA");
		else
			for(int i = 0 ; i < indexR ; i++)
				System.out.print(result[i]);
	}
}