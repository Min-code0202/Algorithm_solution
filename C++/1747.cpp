#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <string>
using namespace std;
int A[10000001];

bool IsPalindrome(int num)
{
	string str = to_string(num);
	char const* temp = str.c_str();
	int s = 0;
	int e = str.size() - 1;
	while (s < e)
	{
		if (temp[s] != temp[e])
			return false;
		s++;
		e--;
	}
	return true;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n;
	cin >> n;
	for (int i = 2; i < 10000001; i++)
	{
		A[i] = i;
	}
	for (int i = 2; i <= sqrt(10000001); i++)
	{
		if (A[i] == 0)
			continue;
		for (int j = i * 2; j < 10000001; j += i)
		{
			A[j] = 0;
		}
	}
	int i = n;
	while (true)
	{
		if (A[i] != 0)
		{
			if (IsPalindrome(A[i]))
			{
				cout << A[i];
				break;
			}
		}
		i++;
	}
}