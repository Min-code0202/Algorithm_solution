#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

struct  compare // 정렬 기준 정의
{
	bool operator()(int o1, int o2)
	{
		int first_abs = abs(o1);
		int second_abs = abs(o2);
		if (first_abs == second_abs) // 같은 절대값일시
			return o1 > o2; // 음수 우선 정렬
		else
			return first_abs > second_abs; // 절대값 기준 정렬;
	}
};

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	priority_queue<int, vector<int>, compare> pq;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int req;
		cin >> req;
		if (req == 0)
		{
			if (pq.empty())
			{
				cout << "0\n";
			}
			else
			{
				cout << pq.top() << "\n";
				pq.pop();
			}
		}
		else
		{
			pq.push(req);
		}
	}
}