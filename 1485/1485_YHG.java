import java.util.Scanner;

public class Problem_1485 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int T = scn.nextInt(); // 테스트 케이스
		
		for(int TT = 0 ; TT < T ; TT++) {
			int[][] point = new int[4][2];
			for(int i = 0 ; i < 4 ; i++) {
				point[i][0] = scn.nextInt();
				point[i][1] = scn.nextInt();
			}
			
			long[][] len = new long[4][4];
			long[][] save = new long[4][3];
			for(int i = 0 ; i < 4 ; i++) {
				long[] tmp = new long[3];
				for(int j = 0 ; j < 4 ; j++) {
					if(i == j)
						continue;
					long x = (long)Math.pow(point[i][0] - point[j][0], 2);
					long y = (long)Math.pow(point[i][1] - point[j][1], 2);
					len[i][j] = x + y;
				}
				boolean check = false;
				boolean fail = false;
				int index = 0;
				for(int j = 0 ; j < 4 ; j++) {
					if(len[i][j] == 0) {
						if(check) {
							fail = true;
							break;
						}
						check = true;
						continue;
					}
					tmp[index++] = len[i][j];
				}
				
				if(fail) {
					System.out.println(0);
					break;
				}
				
				save[i][0] = tmp[0];
				save[i][1] = tmp[1];
				save[i][2] = tmp[2];
			}
			
			long l = 0;
			if(save[0][0] == save[0][1] || save[0][0] == save[0][2])
				l = save[0][0];
			else if(save[0][1] == save[0][2])
				l = save[0][1];
			else {
				System.out.println(0);
				continue;
			}
			
			boolean check = false;
			for(int i = 0 ; i < 4 ; i++) {
				int count = 0;
				int tmp1 = 0;
				int tmp2 = 0;
				for(int j = 0 ; j < 3 ; j++)
					if(save[i][j] == l) {
						count++;
						tmp1 += save[i][j];
					}
					else
						tmp2 += save[i][j];
				
				if(count != 2 || tmp1 != tmp2) {
					System.out.println(0);
					check = true;
					break;
				}
			}
			if(!check)
				System.out.println(1);
		}
	}
}