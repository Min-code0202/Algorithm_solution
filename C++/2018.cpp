#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n;
	cin >> n;
	int cnt = 1, sum = 1;
	int start = 1, end = 1;

	while (end < n)
	{
		if (sum == n)
		{
			cnt++;
			end++;
			sum += end;
		}
		else if (sum > n)
		{
			sum -= start;
			start++;
		}
		else
		{
			end++;
			sum += end;
		}
	}
	cout << cnt;
}