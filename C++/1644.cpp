#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
typedef  long long num;

num n;
vector<num> prime;

void eratos(num n) {
	vector<bool> isprime(n + 1, 1);
	for (num i = 2; i * i <= n; i++) {
		if (!isprime[i]) continue;
		for (num j = i * i; j <= n; j += i) isprime[j] = 0;
	}
	for (num i = 2; i <= n; i++) if (isprime[i]) prime.push_back(i);
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	cin >> n;
	eratos(n);

	// for문이 돌 때마다 좌측 소수를 제거하고, 우측 소수를 추가할지 확인.
	num ans{}, tot{}, en{};
	for (num st = 0; st < prime.size(); st++) {
		while (en < prime.size() && tot < n) tot += prime[en++];
		if (tot == n) ans++;
		tot -= prime[st];
	}
	cout << ans;
}