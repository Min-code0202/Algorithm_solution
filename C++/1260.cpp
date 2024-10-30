#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
typedef int num;

static vector<vector<num>> A;
static vector<bool> visited;

void dfs(num node) {
	cout << node << " ";
	visited[node] = true;
	for (num i : A[node]) {
		if (!visited[i]) {
			dfs(i);
		}
	}
}
void bfs(num node) {
	queue<int> q;
	q.push(node);
	visited[node] = true;
	while (!q.empty()) {
		num current = q.front();
		q.pop();
		cout << current << " ";
		for (num i : A[current]) {
			if (!visited[i]) {
				visited[i] = true;
				q.push(i);
			}
		}
	}
}
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	num n, m, v;
	cin >> n >> m >> v;
	A.resize(n + 1);
	for (num i = 0; i < m; i++) {
		num s, e;
		cin >> s >> e;
		A[s].push_back(e);
		A[e].push_back(s);
	}
	for (num i = 1; i <= n; i++) {
		sort(A[i].begin(), A[i].end());
	}

	visited = vector<bool>(n + 1, false);
	dfs(v);
	cout << "\n";
	fill(visited.begin(), visited.end(), false);
	bfs(v);
	cout << "\n";
}