#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef int num;



int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	num T, N, M, a, b;
	cin >> T;
	while (T--) {
		cin >> N >> M;
		for (num i = 0; i < M; i++) {
			cin >> a >> b;
		}
		cout << N - 1 << "\n";
	}
}
