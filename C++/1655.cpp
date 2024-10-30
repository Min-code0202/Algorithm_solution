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

	int n;
	cin >> n;
	priority_queue<int> left;
	priority_queue<int, vector<int>, greater<int>> right;

	int current;
	while (n--) {
		cin >> current;
		(left.size() <= right.size()) ? left.push(current) : right.push(current);

		if (right.size() && left.top() > right.top()) {
			left.push(right.top());
			right.pop();
			right.push(left.top());
			left.pop();
		}
		cout << left.top() << "\n";
	}

}