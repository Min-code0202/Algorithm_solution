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

	int n;
	cin >> n;
	vector<int> A(n, 0);
	vector<int> Ans(n, -1);
	stack<int> stack;
	for (int i = 0; i < n; i++)
	{
		cin >> A[i];
	}
	stack.push(0);
	for (int i = 1; i < n; i++)
	{
		while (!stack.empty() && A[i] > A[stack.top()])
		{
			Ans[stack.top()] = A[i];
			stack.pop();
		}
		stack.push(i);
	}

	for (int i = 0; i < n; i++)
	{
		cout << Ans[i] << " ";
	}
}