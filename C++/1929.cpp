#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int m, n;
	cin >> m >> n;

	vector<int> A(n + 1);
	for (int i = 2; i <= n; i++)
	{
		A[i] = i;
	}
	for (int i = 2; i <= sqrt(n); i++)
	{
		if (A[i] == 0)
			continue;
		for (int j = i * 2; j <= n; j += i)
		{
			A[j] = 0;
		}
	}
	for (int i = m; i <= n; i++)
	{
		if (A[i] != 0)
			cout << A[i] << "\n";
	}
}