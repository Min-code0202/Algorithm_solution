#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef int num;

vector<vector<num>> A;
vector<bool> visited;
vector<num> check;
bool iseven;

void dfs(num node) {
	visited[node] = true;
	for (num v : A[node]) {
		if (!visited[v]) {
			check[v] = (check[node] + 1) % 2;
			dfs(v);
		}
		else if (check[node] == check[v]) {
			iseven = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	int K, V, E, u, v;
	cin >> K;
	while (K--) {
		cin >> V >> E;
		A = vector<vector<num>>(V + 1);
		visited = vector<bool>(V + 1, false);
		check = vector<num>(V + 1);
		iseven = true;
		for (num i = 0; i < E; i++) {
			cin >> u >> v;
			A[u].push_back(v);
			A[v].push_back(u);
		}
		for (num i = 1; i <= V; i++) {
			if (!iseven) break;
			dfs(i);
		}
		cout << (iseven ? "YES" : "NO") << "\n";
	}
}