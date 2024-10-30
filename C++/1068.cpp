#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef long long num;

vector<vector<num>> tree;
vector<bool> visited;

num ans = 0;
num deleteNode = 0;
num N;

void dfs(num node);

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	cin >> N;
	tree.resize(N);
	visited = vector<bool>(N, false);
	num root, p;
	for (num i = 0; i < N; i++) {
		cin >> p;
		if (p == -1) root = i;
		else tree[p].push_back(i);
	}
	cin >> deleteNode;

	dfs(root);
	if (deleteNode == root) {
		cout << 0;
	}
	else {
		cout << ans;
	}

}

void dfs(num index) {
	visited[index] = true;
	num childCount = 0;
	for (num i : tree[index]) {
		if (visited[i] || i == deleteNode) continue;
		childCount++;
		dfs(i);
	}
	if (!childCount) ans++;
}