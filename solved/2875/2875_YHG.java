import java.util.Scanner; // Scanner로 입력 받기 위해 사용

public class Problem_2875 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		int k = scn.nextInt();
		
		int count = 0;
		int tmp = 0;
		
		if(n/2 > m) {
			// n/2 가 m보다 크다는 것은, 팀을 다 만들고 나서 여자가 남는다는 것.
			tmp += n - m*2;
			
			// 여자 2 : 남자 1 의 팀. 여자가 남는다는 것은, 남자의 명수 m 만큼의 팀이 만들어진다는 것
			count = m;
			
		} else if (n/2 < m){
			// 그렇지 않다는 것은 남자가 남는다는 것.
			tmp += m - n/2;
			
			// 남자가 남는다는 것은, 여자의 명수/2 한 만큼의 팀이 만들어 진다는 것.
			count = n/2;
			
			if(n%2 != 0)	// n이 2로 나누어 떨어지지 않는다는 것은, 여자 한명은 무조건 남는다는 것.
				tmp += 1;
					
		} else {
			// n/2 == m 이라는 것은, 딱 맞아 떨어진다는 것.
			count = m;
			
			if(n%2 != 0)	// 팀이 딱 맞을 때, n/2의 결과가 정수이기 때문에 나머지가 있는 경우, 한명의 여자가 남게 된다.
				tmp += 1;
		}
		
		if( k == 0 ) 
			System.out.println(count);
		else {
			k -= tmp;
			if(k > 0) {
				// 팀을 이루지 못한 사람을 인턴쉽으로 빼도 인원이 부족할 경우. 팀을 하나씩 해체하면서 카운트 한다.
				while(true) {
					// 팀 하나를 해체하고 그 3명을 인턴쉽 인원으로 할당한다.
					count--;
					k -= 3;
					
					// 인턴쉽 할당 인원이 0이하가 되면 while 을 끝낸다.
					if(k <= 0 ) break;
				}
				System.out.println(count);
				
			} else	// 팀을 이루지 못한 사람이 인턴쉽 인원보다 클 경우. 팀의 수는 그대로.
				System.out.println(count);
		}

	}

}
