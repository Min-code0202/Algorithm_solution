#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int k;
	cin >> k;
	stack<int> stack;

	for (int i = 0; i < k; i++)
	{
		int a;
		cin >> a;
		if (a)
		{
			stack.push(a);
		}
		else
		{
			stack.pop();
		}
	}
	int sum = 0;
	while (!stack.empty())
	{
		sum += stack.top();
		stack.pop();
	}
	cout << sum;

}