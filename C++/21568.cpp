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

	num a, b, c;
	cin >> a >> b >> c;
	num g = gcd(a, b);
	if (c % g) cout << -1;
	else {
		num mok = (int)(c / g);
		vector<num> ret = Excute(a, b);
		cout << ret[0] * mok << " " << ret[1] * mok;
	}
}
num gcd(num a, num b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}
vector<num> Excute(num a, num b) {
	vector<num> ret(2);
	if (b == 0) {
		ret[0] = 1;
		ret[1] = 0;
		return ret;
	}
	num q = a / b;
	vector<num> v = Excute(b, a % b);
	ret[0] = v[1];
	ret[1] = v[0] - v[1] * q;
	return ret;
}
