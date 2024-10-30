#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	priority_queue<int, vector<int>, greater<int>> minQ;
	int n, x;
	cin >> n;
	for (int i = 0; i < n * n; i++)
	{
		cin >> x;
		minQ.push(x);
		if (minQ.size() > n) minQ.pop();
	}
	cout << minQ.top();
}