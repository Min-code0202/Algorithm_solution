#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef int num;

void hanoi(num k, num start, num mid, num target);

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	num N;
	cin >> N;
	num ans = 1;
	for (num i = 0; i < N; i++) ans *= 2;
	cout << ans - 1 << "\n";
	hanoi(N, 1, 2, 3);
}

void hanoi(num k, num start, num mid, num target) {
	if (k <= 0) return;
	hanoi(k - 1, start, target, mid);
	cout << start << " " << target << "\n";
	hanoi(k - 1, mid, start, target);

}