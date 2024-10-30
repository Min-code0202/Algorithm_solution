#include <iostream>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int n, tmp;
	cin >> n;

	int ans{};
	stack<int> stack;
	for (int i = 0; i <= n; i++) {
		int y;
		if (i != n) cin >> tmp >> y;
		else y = 0;
		while (!stack.empty() && stack.top() > y) stack.pop();
		if (y && (stack.empty() || stack.top() < y)) {
			stack.push(y);
			ans++;
		}
	}
	cout << ans;
}