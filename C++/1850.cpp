#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
typedef long long ll;
ll gcd(ll a, ll b);
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	ll a, b;
	cin >> a >> b;
	ll n = gcd(a, b);
	while (n--) cout << 1;

}
ll gcd(ll a, ll b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}