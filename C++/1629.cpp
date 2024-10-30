#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef long long int num;

vector<vector<num>> tree;
vector<bool> visited;

num A, B, C;

num multi(num n, num k);

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	cin >> A >> B >> C;
	cout << multi(A, B);
}

num multi(num n, num k) {
	if (k == 0)
		return 1;
	else if (k == 1)
		return n % C;
	else if (k % 2 == 0)
		return (multi(n, k / 2) * multi(n, k / 2)) % C;
	else
		return (multi(n, k / 2 + 1) * multi(n, k / 2)) % C;
}