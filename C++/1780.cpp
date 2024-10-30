#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef int num;
struct coordinate {
	num row;
	num col;
};
vector<vector<num>> map;
vector<num> ans(3, 0);


bool allSame(coordinate a, coordinate b);
void recursive(coordinate a, coordinate b);


int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	num N, t;
	cin >> N;
	map.resize(N);
	for (num i = 0; i < N; i++) {
		for (num j = 0; j < N; j++) {
			cin >> t;
			map[i].push_back(t);
		}
	}
	recursive(coordinate(0, 0), coordinate(N - 1, N - 1));

	for (num i = 0; i < 3; i++) {
		cout << ans[i] << "\n";
	}

}
bool allSame(coordinate a, coordinate b) {
	num type = map[a.row][a.col];
	for (num i = a.row; i <= b.row; i++) {
		for (num j = a.col; j <= b.col; j++) {
			if (type != map[i][j]) {
				return false;
			}
		}
	}
	return true;
}
void recursive(coordinate a, coordinate b) {
	
	if (allSame(a, b)) {
		ans[map[a.row][a.col] + 1]++;
	}
	else {
		num len = (b.row - a.row + 1) / 3;
		for (num i = 0; i < 3; i++) {
			for (num j = 0; j < 3; j++) {
				recursive(coordinate(a.row + len * i, a.col + len * j), coordinate(a.row + len * (i + 1) - 1, a.col + len * (j + 1) - 1));
			}
		}
	}
}