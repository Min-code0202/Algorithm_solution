#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>
using namespace std;
typedef pair<int, int> Node;
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n, l;
	cin >> n >> l;

	deque<Node> dq;
	for (int i = 0; i < n; i++)
	{
		int now;
		cin >> now;
		while (dq.size() && dq.back().first > now)
		{
			dq.pop_back();
		}
		dq.push_back(Node(now, i));

		if (dq.front().second <= i - l)
		{
			dq.pop_front();
		}
		cout << dq.front().first << " ";
	}
}