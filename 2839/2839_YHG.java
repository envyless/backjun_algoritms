import java.util.Scanner; // Scanner로 입력 받기 위해 사용

public class Problem_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int N;
		int count = 0;
		
		N = scn.nextInt();
		
		if(N == 3) count = 1;
		else if(N == 4) count = -1;
		else { // 5 이상일 경우
			
			if(N % 5 == 0) { // 5로 딱 나누어 떨어질 경우
				count = N/5;
			}
			else {
				// 5로 딱 나누어 지지 않을 경우
				int tmp;
				
				// N에서 5의 배수를 뺀 후 3으로 나누어 본다.
				for(int i = 5; i < N ; i+=5) {
					tmp = N - i;
					// 5의 배수를 뺀 값이 3으로 나누어 지면
					if(tmp % 3 == 0) {
						count = tmp/3;
						count += i/5;
					}
				}
				
				// 5의 배수를 뺀 값이 3으로 나누어 떨어지면 count 값은 0이 아니다.
				// 0이라는 것은 5의 배수를 뺀 값 중 3으로 나누어지지 않는다는 것.
				if(count == 0) {
					// N이 3의 배수일 경우
					if(N % 3 == 0) {
						count = N/3;
					}
				}
			}
			
		}
		
		// 위의 조건에 한번도 해당하지 않으면 3,5로 딱 나누어지지 않는다는 것.
		if(count == 0) count = -1;
		
		System.out.println(count);
	}
}
