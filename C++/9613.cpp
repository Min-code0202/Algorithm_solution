#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
typedef  long long num;
num gcd(num a, num b);
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	num t, n, a, b;
	cin >> t;
	while (t--)
	{
		num sum = 0;
		cin >> n;
		vector<num> vec(n);
		for (num i = 0; i < n; i++) cin >> vec[i];
		for (num i = 0; i < n - 1; i++)
		{	
			for (num j = i + 1; j < n; j++)
			{
				sum += gcd(vec[i], vec[j]);
			}
		}
		cout << sum << "\n";
	}

}
num gcd(num a, num b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}
