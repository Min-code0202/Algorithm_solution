#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	long min, max;
	cin >> min >> max;

	vector<bool> Check(max - min + 1);

	for (long i = 2; i * i <= max; i++)
	{
		long pow = i * i;
		long start_index = min / pow;
		if (min % pow != 0)
			start_index++;
		for (long j = start_index; pow * j <= max; j++)
		{
			Check[(int)((j * pow) - min)] = true;
		}
	}
	int count = 0;
	for (int i = 0; i <= max - min; i++)
	{
		if (!Check[i])
			count++;
	}
	cout << count;
}