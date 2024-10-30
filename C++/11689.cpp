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

	long long n;
	cin >> n;

	long long result = n;
	for (long long k = 2; k * k <= n; k++)
	{
		if (n % k == 0) {
			result = result - (result / k);
			while (n % k == 0) n /= k;
		}
	}
	if (n > 1) {
		result = result - (result / n);
	}
	cout << result;
}