#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int gcd(int a, int b);
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int t;
	cin >> t;
	int a, b;
	while (t--) {
		cin >> a >> b;
		cout << a * b / gcd(a, b) << "\n";
	}
}
int gcd(int a, int b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}