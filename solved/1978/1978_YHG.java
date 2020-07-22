import java.util.Scanner;

public class Problem_1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // ÀÚ¿¬¼ö
		int[] insert = new int[N];
		int[] check = new int[1001];
		int count = 0;
		
		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
		
		for(int i = 1 ; i < 1001 ; i++)
			check[i] = i;
		
		for(int i = 0 ; i < N ; i++) {
			int div = 0;
			if(insert[i] == 1)
				continue;
			else 
				for(int j = 2 ; j <= insert[i] ; j++) 
					if(insert[i] % check[j] == 0) 
						div++;
			
			if(div == 1)
				count++;
		}
		System.out.println(count);	
	}
}