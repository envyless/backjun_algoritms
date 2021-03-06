// ConsoleApplication1.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//

#include "stdafx.h"
#include<stdio.h>


int max(int i, int j) {
	int temp;
	if (i>j)
		temp = i;
	else
		temp = j;
	return temp;
}

int main()
{
	int n, ans, pl[100000] = { 0 };

	scanf_s("%d", &n);

	for (int i = 0; i <= n; i++)
		scanf_s("%d", &pl[i]);

	ans = pl[0];
	for (int i = 1; i <= n; i++)
	{
		pl[i] = max(pl[i], pl[i] + pl[i - 1]);
		ans = max(ans, pl[i - 1]);
	}
	printf("%d", ans);
}