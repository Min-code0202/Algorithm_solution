#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef int num;

vector<vector<num>> A;
vector<num> visited;
vector<num> ans;
num cnt = 0;
num maxCnt = 0;

void dfs(num node) {
	visited[node] = true;
	cnt++;
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
	ans.resize(n + 1);

	for (num i = 0; i < m; i++) {
		cin >> u >> v;
		A[v].push_back(u);
	}
	for (num i = 1; i <= n; i++) {
		visited.clear();
		visited.resize(n + 1);
		dfs(i);
		if (cnt == maxCnt) {
			ans.push_back(i);
		}
		else if (cnt > maxCnt) {
			maxCnt = cnt;
			ans.clear();
			ans.push_back(i);
		}
		cnt = 0;
	}
	for (num i = 0; i < size(ans); i++) {
		cout << ans[i] << " ";
	}
}