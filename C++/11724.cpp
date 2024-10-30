#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef int num;

vector<vector<num>> A;
vector<num> visited;
num cnt = 0;

void dfs(num node) {
	visited[node] = true;
	for (num v : A[node]) {
		if (visited[v]) continue;
		dfs(v);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n, m, u, v;
	cin >> n >> m;
	A.resize(n + 1);
	visited.resize(n + 1);

	for (num i = 0; i < m; i++) {
		cin >> u >> v;
		A[u].push_back(v);
		A[v].push_back(u);
	}
	for (num i = 1; i <= n; i++) {
		if (visited[i])continue;
		dfs(i);
		cnt++;
	}
	cout << cnt;
}