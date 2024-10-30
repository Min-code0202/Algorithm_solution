#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
typedef int num;

struct edge {
	num a;
	num b;
};
static vector <vector<edge>> A;
static vector<bool> visited;
static vector<num> m_distance;

num N;

void bfs(num index) {
	queue<num> q;
	q.push(index);
	visited[index] = true;

	while (!q.empty()) {
		num now_node = q.front();
		q.pop();
		for (edge i : A[now_node]) {
			if (!visited[i.a]) {
				visited[i.a] = true;
				q.push(i.a);
				m_distance[i.a] = m_distance[now_node] + i.b;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	num E, V, S;
	cin >> N;
	A.resize(N + 1);
	for (num i = 0; i < N; i++) {
		cin >> S;
		while (true) {
			cin >> E;
			if (E == -1) break;
			cin >> V;
			A[S].push_back(edge(E, V));
		}
	}
	m_distance = vector<num>(N + 1, 0);
	visited = vector<bool>(N + 1, false);
	bfs(1);
	num Max = 1;
	for (num i = 2; i <= N; i++) {
		if (m_distance[Max] < m_distance[i])
			Max = i;
	}
	fill(m_distance.begin(), m_distance.end(), 0);
	fill(visited.begin(), visited.end(), false);
	bfs(Max);
	num ans = 0;
	for (num i = 1; i <= N; i++) {
		if (m_distance[i] > ans)
			ans = m_distance[i];
	}
	cout << ans << "\n";
}