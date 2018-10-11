import java.io.*;
import java.util.Arrays;

public class Problem_1302 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int N = Integer.parseInt(br.readLine()); // Ã¥ÀÇ ¼ö
		String[] name = new String[N];
		
		for(int i = 0 ; i < N ; i++)
			name[i] = br.readLine();
		Arrays.sort(name);
		
		String[] celler = new String[N];
		int[] value = new int[N];
		int index = 1;
		
		celler[0] = name[0];
		value[0]++;
		
		for(int i = 1 ; i < N ; i++) {
			boolean check = false;
			for(int j = 0 ; j < N ; j++) {
				if(value[j] == 0)
					break;
				if(name[i].equals(celler[j])) {
					value[j]++;
					check = true;
					break;
				}
			}
			if(!check) {
				celler[index] = name[i];
				value[index] = 1;
				index++;
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < index ; i++)
			if(max < value[i])
				max = value[i];
		
		for(int i = 0 ; i < index ; i++)
			if(max == value[i]) {
				System.out.println(celler[i]);
				break;
			}
	}
}