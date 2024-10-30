#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef int num;

vector<vector<num>> A;
vector<bool> visited;
num isexist = 0;
void dfs(num node, num depth) {
	if (depth == 5 || isexist) {
		isexist = 1;
		return;
	}
	visited[node] = true;
	for (num v : A[node]) {
		if (visited[v]) continue;
		dfs(v, depth + 1);
	}
	visited[node] = false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n, m, u, v;
	cin >> n >> m;
	A.resize(n + 1);
	visited = vector<bool>(n, false);
	for (num i = 0; i < m; i++) {
		cin >> u >> v;
		A[u].push_back(v);
		A[v].push_back(u);
	}
	for (num i = 0; i < n; i++) {
		dfs(i, 1);
		if (isexist) break;
	}
	cout << isexist;

}