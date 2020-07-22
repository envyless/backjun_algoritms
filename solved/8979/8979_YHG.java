import java.util.Scanner;

public class Problem_8979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		// 국가의 갯수
		int N = scn.nextInt();
		// 등수를 알고싶은 국가의 번호
		int K = scn.nextInt();
		// 국가번호 / 금메달 / 은메달 / 동메달
		int[][] insert = new int[N][4];
		// K의 메달
		int[] KM = new int[4];
		// K의 등수. 1등부터 시작.
		int num = 1;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				insert[i][j] = scn.nextInt();
			}
			if(insert[i][0] == K) {
				KM[1] = insert[i][1];
				KM[2] = insert[i][2];
				KM[3] = insert[i][3];
			}
		}
		
		
		// 전체 경우를 확인
		for(int i = 0 ; i < N ; i++) {
			// 금메달이 많은 경우
			if(insert[i][1] > KM[1]) {
				num++;
			}
			// 금메달이 같은 경우. 은메달을 확인해야 함.
			else if(insert[i][1] == KM[1]) {
				// 은메달이 더 많은경우
				if(insert[i][2] > KM[2]) {
					num++;
				}
				// 은메달도 같은 경우 동메달을 확인해야 함.
				else if(insert[i][2] == KM[2]) {
					if(insert[i][3] > KM[3]) {
						num++;
					}
				}
			}
		}
		
		System.out.println(num);
	}
}
