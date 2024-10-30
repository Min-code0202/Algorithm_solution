#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n;
	cin >> n;
	vector<long> vec(n, 0);

	for (int i = 0; i < n; i++)
	{
		cin >> vec[i];
	}
	sort(vec.begin(), vec.end());

	int cnt = 0;

	for (int pos = 0; pos < n; pos++)
	{
		int k = vec[pos];
		int start = 0;
		int end = n - 1;
		while (start < end)
		{
			int sum = vec[start] + vec[end];
			if (sum == k)
			{
				if (start != pos && end != pos)
				{
					cout << vec[start] << " " << vec[end] << "\n";
					cnt++;
					break;
				}
				else if (start == pos)
					start++;
				else
					end--;
			}
			else if (sum > k)
			{
				end--;
			}
			else
			{
				start++;
			}
		}
	}
	cout << cnt;
}