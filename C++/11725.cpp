#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
typedef int num;

static int n;
static vector<num> ans;
static vector<bool> visited;
static vector<vector<num>> tree;
void dfs(num number);

int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	cin >> n;
	ans.resize(n + 1);
	visited.resize(n + 1);
	tree.resize(n + 1);

	num a, b;
	for (num i = 0; i < n - 1; i++) {
		cin >> a >> b;
		tree[a].push_back(b);
		tree[b].push_back(a);
	}
	dfs(1);
	for (num i = 2; i <= n; i++) {
		cout << ans[i] << "\n";
	}
}

void dfs(num number) {
	visited[number] = true;
	for (num node : tree[number]) {
		if (visited[node]) continue;
		ans[node] = number;
		dfs(node);
	}
}
