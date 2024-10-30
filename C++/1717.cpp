#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
typedef long long num;

vector<num> rep;

void _union(num a, num b);
num _find(num a);
bool _checkSame(num a, num b);

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	num n, m;
	cin >> n >> m;

	rep.resize(n + 1);
	for (num i = 0; i <= n; i++) {
		rep[i] = i;
	}

	num k, a, b;
	while (m--) {
		cin >> k >> a >> b;
		if (k) cout << (_checkSame(a, b) ? "YES\n" : "NO\n");
		else _union(a, b);
	}

}

void _union(num a, num b) {
	a = _find(a);
	b = _find(b);
	if (a != b) rep[b] = a;
}

num _find(num a) {
	if (a == rep[a])
		return a;
	else
		return rep[a] = _find(rep[a]);
}

bool _checkSame(num a, num b) {
	return _find(a) == _find(b);
}
