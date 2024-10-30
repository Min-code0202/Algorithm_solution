#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef int num;

vector<vector<num>> tree;
num recursive(num n, num r, num c);
int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	num N, R, C;
	cin >> N >> R >> C;

	cout << recursive(N, R, C);
}
num recursive(num n, num r, num c) {
	if (n == 0) return 0;
	num half = 1 << (n - 1);

	if (r < half and c < half) return recursive(n - 1, r, c);
	else if (r >= half and c >= half) return half * half * 3 + recursive(n - 1, r - half, c - half);
	else if (r >= half and c < half) return half * half * 2 + recursive(n - 1, r - half, c);
	else return half * half + recursive(n - 1, r, c - half);
}