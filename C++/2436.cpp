#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <numeric>
using namespace std;
typedef long long num;

int main()
{
	pair<num, num> ans;
	num g, l;
	cin >> g >> l;

	num div = l / g;
	for (num i = 1; i * i <= div; i++) {
		if (div % i || gcd(i, div / i) != 1)  continue;
		ans = { i * g, (div / i) * g };
	}
	cout << ans.first << " " << ans.second;
}