#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

// i를 볼 수 있는 빌딩 단위로 더함

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n, k;
	cin >> n >> k;
	queue<int> queue;
	for (int i = 1; i <= n; i++)
	{
		queue.push(i);
	}

	cout << "<";
	while (queue.size() > 1)
	{
		for (int i = 1; i < k; i++) {
			queue.push(queue.front());
			queue.pop();
		}
		cout << queue.front() << ", ";
		queue.pop();
	}

	cout << queue.front() << ">";
}