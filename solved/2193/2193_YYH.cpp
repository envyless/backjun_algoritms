// ConsoleApplication2.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//

#include "stdafx.h"
#include<stdio.h>
int main(void) {

	int n, i = 0;
	scanf("%d", &n);
	long long int binary[91];
	binary[0] = 0;
	binary[1] = 1;
	for (i = 2; i <= n; i++)
		binary[i] = binary[i - 1] + binary[i - 2];

	printf("%lld", binary[n]);

	return 0;
}