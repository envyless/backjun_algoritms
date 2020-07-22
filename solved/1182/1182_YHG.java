import java.util.Scanner;

public class Problem_1182 {
	static Scanner scn = new Scanner(System.in);

	static int N = scn.nextInt(); // �ڿ����� ����
	static int S = scn.nextInt(); // ���� ����.
	
	static int[] insert = new int[N];
	static int result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0 ; i < N ; i++)
			insert[i] = scn.nextInt();
	
		dfs(0,0);
		// ��� ����� ���� �����ؾ� ��.
		System.out.println(result);
	}
	
	static void dfs(int index, int total){
		if(index == N)
			return;
		if(total + insert[index] == S )
			result++;
		
		dfs(index+1,total+insert[index]);
		dfs(index+1,total);
	}
}