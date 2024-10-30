#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
typedef int num;
num gcd(num a, num b);
vector<num> Excute(num a, num b);
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int n, k, ans;
	cin >> n >> k;
	vector<bool> isprime(n + 1, 1);

	for (int i = 2; i <= n; i++) {
		if (!isprime[i]) continue;
		for (int j = i; j <= n; j += i) {
			if (!isprime[j]) continue;
			isprime[j] = 0;
			if (--k == 0) ans = j;
		}
	}
	cout << ans;
}