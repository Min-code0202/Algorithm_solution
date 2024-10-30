#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n;
	cin >> n;
	queue<int> queue;
	for (int i = 1; i <= n; i++)
	{
		queue.push(i);
	}
	while (queue.size() > 1)
	{
		queue.pop();
		queue.push(queue.front());
		queue.pop();
	}
	cout << queue.front();
}