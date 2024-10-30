#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <numeric>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n, w, l;
	cin >> n >> w >> l;
	queue<int> queue;
	int onBridge[105];
	int weight = 0;
	int ans = 0;
	for (int i = 0; i < 105; i++)
	{
		onBridge[i] = 0;
	}
	for (int i = 0; i < n; i++)
	{
		int c;
		cin >> c;
		queue.push(c);
	}

	do
	{
		weight = accumulate(onBridge, onBridge + w, 0);

		weight -= onBridge[w - 1];
		for (int i = w - 1; i > 0; i--) onBridge[i] = onBridge[i - 1];
		onBridge[0] = 0;
		if (!queue.empty() && (weight + queue.front() <= l)) {
			onBridge[0] = queue.front();
			queue.pop();
		}

		ans++;
	} while (accumulate(onBridge, onBridge + w, 0));

	cout << ans;
}