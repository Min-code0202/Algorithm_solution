#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
typedef int num;

vector<vector<num>> A;
vector<num> dist;
vector<num> ans;
num n, m, k, x;

void bfs(num start) {
	queue<num> q;
	q.push(start);
	dist[start] = 1;
	while (!q.empty()) {
		num current = q.front();
		q.pop();
		for (num i : A[current]) {
			if (dist[i]) continue;
			dist[i] = dist[current] + 1;
			if (dist[i] == k + 1) ans.push_back(i);
			q.push(i);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	cin >> n >> m >> k >> x;
	A.resize(n + 1);
	dist.resize(n + 1);
	num a, b;
	for (num i = 0; i < m; i++) {
		cin >> a >> b;
		A[a].push_back(b);
	}
	bfs(x);
	sort(ans.begin(), ans.end());
	if (ans.empty()) {
		cout << -1 << "\n";
	}
	else {
		for (num i : ans) {
			cout << i << "\n";
		}
	}
}