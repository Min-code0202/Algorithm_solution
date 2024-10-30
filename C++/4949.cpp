#include <iostream>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;

string s;

bool solve()
{
	stack<char> stack;
	for (char c : s)
	{
		if (c == '(' || c == '[') stack.push(c);
		else if (c == ')') {
			if (stack.empty() || stack.top() != '(') return false;
			stack.pop();
		}
		else if (c == ']') {
			if (stack.empty() || stack.top() != '[') return false;
			stack.pop();
		}
	}
	return stack.empty();
}

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	while (getline(cin, s), s != ".")
	{
		cout << (solve() ? "yes\n" : "no\n");
	}
}