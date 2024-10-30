#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
long A[10000001];
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	long a, b;
	cin >> a >> b;

	for (int i = 2; i < 10000001; i++)
	{
		A[i] = i;
	}
	for (int i = 2; i <= sqrt(10000001); i++) // 에라토스테네스의 체
	{
		if (A[i] == 0)
			continue;
		for (int j = i * 2; j < 10000001; j += i)
		{
			A[j] = 0;
		}
	}
	int count = 0;
	for (int i = 2; i < 10000001; i++)
	{
		if (A[i] != 0) // i가 소수라면, i의 제곱수들을 모두 카운트
		{
			long temp = A[i];
			while ((double)A[i] <= (double)b / (double)temp) // b보다 작은 범위까지 탐색
			{
				if ((double)A[i] >= (double)a / (double)temp) // a보다 큰 범위만 카운트
				{
					count++;
				}
				temp = temp * A[i]; // 다음 제곱수
			}
		}
	}
	cout << count;
}