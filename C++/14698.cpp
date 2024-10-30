#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;
using ll = long long;

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	ll mod = 1000000007;
	ll t;
	cin >> t;
	while (t--) {
		ll n;
		cin >> n;
		priority_queue<ll, vector<ll>, greater<ll>> pq;
		while (n--) {
			ll x;
			cin >> x;
			pq.push(x);
		}

		ll ans = 1;
		while (pq.size() > 1) {
			ll a = pq.top();
			pq.pop();
			ll b = pq.top();
			pq.pop();
			ll ab = (a * b) % mod;
			ans = (ans * ab) % mod;
			pq.push(a * b);
		}
		cout << ans << "\n";
	}

}