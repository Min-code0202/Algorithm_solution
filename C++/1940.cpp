#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;
	vector<int> vec(n, 0);

	for (int i = 0; i < n; i++)
	{
		cin >> vec[i];
	}
	sort(vec.begin(), vec.end());

	int cnt = 0;
	int start = 0;
	int end = n - 1;

	while (start < end)
	{
		int sum = vec[start] + vec[end];
		if (sum == m)
		{
			cnt++;
			end--;
		}
		else if (sum > m)
		{
			end--;
		}
		else
		{
			start++;
		}
	}
	cout << cnt;
}