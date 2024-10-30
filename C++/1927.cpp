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
	int n, item, item2;
	cin >> n;
	while (n--) {
		cin >> item;
		if (item)minQ.push(item);
		else if (minQ.empty()) cout << 0 << "\n";
		else {
			cout << minQ.top() << "\n";
			minQ.pop();
		}
	}
}