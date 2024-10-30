#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;
typedef pair<int, int> Node;
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n;
	cin >> n;

	vector<int> A(n, 0);
	vector<char> resultV;
	for (int i = 0; i < n; i++)
	{
		cin >> A[i];
	}
	stack<int> stack;
	int num = 1;
	bool result = true;

	for (int i = 0; i < n; i++)
	{
		int su = A[i];
		if (su >= num)
		{
			while (su >= num)
			{
				stack.push(num++);
				resultV.push_back('+');
			}
			stack.pop();
			resultV.push_back('-');
		}
		else
		{
			int n = stack.top();
			stack.pop();

			if (n > su)
			{
				cout << "NO";
				result = false;
				break;
			}
			else
			{
				resultV.push_back('-');
			}
		}
	}
	if (result)
	{
		for (int i = 0; i < resultV.size(); i++)
		{
			cout << resultV[i] << "\n";
		}
	}

}