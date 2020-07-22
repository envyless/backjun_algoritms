import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_2251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int A = scn.nextInt(); // 비어 있어야함.
		int B = scn.nextInt();
		int C = scn.nextInt(); // 가득 차있음. 1 ~ 200
		
		int[] insert = { A, B, C };
		boolean[] water = new boolean[C+1]; // 0 ~ C 리터까지 가능.
		boolean[][] check = new boolean[A+1][B+1];
		water[C] = true;
		
		Queue<water_2251> q = new LinkedList<water_2251>();
		q.add(new water_2251(0,0,C));

		while(!q.isEmpty()) {
			water_2251 now = q.poll();
			int[] nowW = {now.A , now.B, now.C};
			int[] nextW = new int[3];

			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(i == j || nowW[i] == 0)
						continue;
					for(int k = 0 ; k < 3 ; k++)
						nextW[k] = nowW[k];
					
					if(nowW[i] > insert[j] - nowW[j]) { // i에서 옮겨야 할 물이 j가 수용할 수 있는 용량보다 큼.
						// j가 수용할 수 있는 물은, 전체 용량 - 현재 차있는 용량
						nextW[j] = insert[j]; // j의 용량은 가득참.
						nextW[i] = nowW[i] - (insert[j] - nowW[j]); // i는 현재 물에서 j가 수용할 수 있을만큼 뺀 후 나머지가 저장.
					}
					else { // j가 현재 i의 물은 모두 수용할 수 있음.
						nextW[j] = nowW[i] + nowW[j];
						nextW[i] = 0;
					}
					
					if(!check[nextW[0]][nextW[1]]) {
						check[nextW[0]][nextW[1]] = true;
						q.add(new water_2251(nextW[0], nextW[1], nextW[2]));
						if(nextW[0] == 0)
							water[nextW[2]] = true;
					}
				}
			}
		}
		
		for(int i = 0 ; i <= C ; i++)
			if(water[i])
				System.out.print(i + " ");
	}
}
class water_2251{
	int A;
	int B;
	int C;
	
	public water_2251(int A, int B, int C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
}