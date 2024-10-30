#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
using namespace std;

// i를 볼 수 있는 빌딩 단위로 더함

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int n, h;
	cin >> n >> h;
	stack<long> stack;
	long long cnt = 0;
	stack.push(1000000010);
	stack.push(h);
	for (int i = 1; i < n; i++)
	{
		cin >> h;
		while (stack.top() <= h) stack.pop();
		cnt += stack.size() - 1;
		stack.push(h);
	}
	cout << cnt;
}