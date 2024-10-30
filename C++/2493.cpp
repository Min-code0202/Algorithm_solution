#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int n;
	cin >> n;

	vector<int> vec(n + 1, 0);
	stack<int> stack;

	for (int i = 1; i <= n; i++)
	{
		cin >> vec[i];
	}
	stack.push(1);
	cout << 0 << " ";
	for (int i = 2; i <= n; i++) {
		while (!stack.empty() && vec[stack.top()] < vec[i]) stack.pop();
		if (stack.empty()) cout << 0 << " ";
		else cout << stack.top() << " ";
		stack.push(i);
	}
}