import java.util.Arrays;
import java.util.Scanner;

public class Problem_1764 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt(); // µè
		int M = scn.nextInt(); // º¸
		
		String[] listen = new String[N];
		String[] see = new String[M];
		
		int max = N;
		if(max < M) max = M;
		String[] check = new String[max];
		int count = 0;
		
		
		for(int i = 0 ; i < N ; i++)
			listen[i] = scn.next();
		
		for(int i = 0 ; i < M ; i++)
			see[i] = scn.next();
		
		if(N == 1 && M == 1)
			if(listen[0].equals(see[0])) {
				System.out.println(1);
				System.out.println(see[0]);
				return ;
			}else {
				System.out.println(count);
				return ;
			}
		
		Arrays.sort(see);
		Arrays.sort(listen);
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		while(a < N && b < M) {
			
			if(listen[a].equals(see[b])) {
				check[c] = listen[a];
				count++;
				a++;
				b++;
				c++;
			}
			else {
				if(listen[a].compareTo(see[b]) < 0)
					a++;
				else
					b++;
			}
		}
		
		System.out.println(count);
		for(int i = 0 ; i < max ; i++) {
			if(check[i] == null) break;
			System.out.println(check[i]);
		}
	}
}