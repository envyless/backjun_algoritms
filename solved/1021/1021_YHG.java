import java.util.Scanner;

public class Problem_1021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt(); // Å¥ÀÇ Å©±â
		int[] queue = new int[N+1];
		for(int i = 1 ; i <= N ; i++)
			queue[i] = i;
		
		int M = scn.nextInt(); // »ÌÀ» ¼öÀÇ °¹¼ö
		int[] del = new int[M];
		
		for(int i = 0 ; i < M ; i++)
			del[i] = scn.nextInt(); // »ÌÀ» ÀÎµ¦½º
		
		int min = 0;
		
		int count = 0;
		int qIndex = 1;
		int delIndex = 0;
		
		while(count < M) {
			
			if(qIndex > N)
				qIndex = 1;
			if(queue[qIndex] == 0) {
				while(true) {
					qIndex++;
					if(qIndex > N)
						qIndex = 1;
					if(queue[qIndex] != 0)
						break;
				}
			}
			
			if(queue[qIndex] == del[delIndex]) {
				queue[qIndex] = 0;
				delIndex++;
				count++;
				qIndex++;
				continue;
			}
			
			
			int tmpTwo = 0;
			int tmpThree = 0;
			int tmpIndex = qIndex;
			int tmpIndex2 = qIndex;
			
			while(true) {
				tmpIndex++;
				tmpTwo++;
				
				if(tmpIndex > N)
					tmpIndex = 1;
				if(queue[tmpIndex] == 0) {
					while(true) {
						tmpIndex++;
						if(tmpIndex > N)
							tmpIndex = 1;
						if(queue[tmpIndex] != 0)
							break;
					}
				}
				
				if(queue[tmpIndex] == del[delIndex])
					break;
			}
			
			while(true) {
				tmpIndex2--;
				tmpThree++;
				if(tmpIndex2 == 0) 
					tmpIndex2 = N;
				
				if(queue[tmpIndex2] == 0) {
					while(true) {
						tmpIndex2--;
						if(tmpIndex2 == 0) 
							tmpIndex2 = N;
						if(queue[tmpIndex2] != 0)
							break;
					}
				}
				if(queue[tmpIndex2] == del[delIndex])
					break;
			}
			
			if(tmpTwo < tmpThree) {
				min += tmpTwo;
				qIndex = tmpIndex;
			}
			else {
				min += tmpThree;
				qIndex = tmpIndex2;
			}
		}
		System.out.println(min);
	}
}