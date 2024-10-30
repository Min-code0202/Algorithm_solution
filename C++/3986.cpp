#include <iostream>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;

string s;
int cnt = 0;
bool solve()
{
	stack<char> stack;
	for (char c : s)
	{
		if (!stack.empty() && stack.top() == c) stack.pop();
		else stack.push(c);
	}
	return stack.empty();
}

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int t;
	cin >> t;
	cin.ignore();
	while (t--)
	{
		getline(cin, s);
		cnt += solve() ? 1 : 0;
	}
	cout << cnt;
}