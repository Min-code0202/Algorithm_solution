#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
typedef int num;
typedef pair<num, num> point;

point direction[4] = { point(1,0), point(-1,0), point(0,1), point(0,-1) };
vector<vector<num>> A;
vector<vector<num>> dist;
num n, m;

void bfs(point start) {
	queue<point> q;
	q.push(start);
	dist[start.first][start.second] = 1;
	while (!q.empty()) {
		point current = q.front();
		q.pop();
		for (point p : direction) {
			num p1 = current.first + p.first;
			num p2 = current.second + p.second;
			if (p1 < 0 || p1 >= n) continue;
			if (p2 < 0 || p2 >= m) continue;
			if (!A[p1][p2]) continue;
			if (dist[p1][p2]) continue;
			dist[p1][p2] = dist[current.first][current.second] + 1;
			q.push(point(p1, p2));
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	cin >> n >> m;
	A = vector<vector<num>>(n, vector<num>(m, 0));
	dist = vector<vector<num>>(n, vector<num>(m, 0));
	string line;
	for (num i = 0; i < n; i++) {
		cin >> line;
		for (num j = 0; j < m; j++) {
			if (line[j] == '1') A[i][j] = 1;
			else A[i][j] = 0;
		}
	}

	bfs(point(0, 0));
	cout << dist[n - 1][m - 1];
}