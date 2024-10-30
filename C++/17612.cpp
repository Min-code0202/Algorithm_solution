#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;
typedef long long ll;
typedef tuple<ll, ll, ll> tll;
typedef pair<ll, ll> pll;
class cmp {
public:
	bool operator()(const tll& a, const tll& b) {
		auto [ax, ay, az] = a;
		auto [bx, by, bz] = b;
		return ((ax == bx) ? (ay < by) : (ax > bx));
	}
};
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	priority_queue<pll, vector<pll>, greater<pll>> tot;
	priority_queue<tll, vector<tll>, cmp> pq;
	ll n, k, id, w;
	ll ans = 0;
	cin >> n >> k;
	for (int i = 1; i <= k; i++) tot.push({ 0,i });
	while (n--)
	{
		cin >> id >> w;
		auto [c_time, c_num] = tot.top();
		tot.pop();
		tot.push({ c_time + w, c_num });
		pq.push({ c_time + w,c_num,id });
	}
	ll cnt = 1;
	while (!pq.empty()) {
		auto [_, __, id] = pq.top();
		pq.pop();
		ans += id * cnt++;
	}
	cout << ans;
}