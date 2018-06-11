import java.util.Scanner; // Scanner로 입력 받기 위해 사용

public class Problem_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int n;
				
		n = scn.nextInt();
		
		int[] input = new int[n];
		
		for(int i = 0 ; i < n ; i++)
			input[i] = scn.nextInt();
		
		// 1개 이상의 연속된 수의 합을 저장할 변수
		int[] result = new int[n];
		int count = 0;
		
		for(int i = 0 ; i < n ; i++) {
			if(input[i] < 0)
				count++;
		}
		
		if(count == n) {
			// 입력된 값이 모두 음수이면.
			output(input,n);
			
		} else {
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = i ; j < n ; j++) {
					if(input[j] >= 0) {
						result[i] += input[j];
					}
					else {
						// 음수를 만났을 경우.
						
						// 첫 값이 음수일 경우. 배열에는 0이 들어가있다. 이 경우 바로 넘어간다.
						if(result[i] <= 0) break;
						
						// 지금까지의 값의 합과 음수의 값을 비교했을 때 음수가 나오면 바로 넘긴다.
						if(input[j] + result[i] <= 0) break;
						
						int tmp = check(input,j,n);			
						
						if(tmp != -1)
							result[i] += tmp;
						
						break;
					}
				}
			}
			output(result,n);
		}

	}
	
	static int check(int[] input, int j, int n) {
		
		int mi = input[j];
		int sum = 0;
		
		for(int i = j+1; i < n ; i++) {
			if(input[i] >= 0)
				sum += input[i];
			else {
				// 다시 음수를 만났을 경우
				int tmp = check(input,i,n);
				
				if(tmp != -1)
					sum += tmp;
				
				break;
			}
		}
		
		if(mi + sum > 0)
			return mi + sum;
		else 
			return -1;
	}
	
	static void output(int[] result, int n) {
		
		int max = result[0];
		int tmp;
		
		for(int i = 1 ; i < n ; i++) {
			if(max < result[i]) {
				max = result[i];
			}
		}
		System.out.println(max);
	}

}