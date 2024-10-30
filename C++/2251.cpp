#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
typedef int num;

struct node {
	num a;
	num b;
};

static num Sender[] = { 0,0,1,1,2,2 };
static num Receiver[] = { 1,2,0,2,0,1 };
static bool visited[201][201];
static bool ans[201];
static num now[3];

void bfs() {
	queue<node> q;
	q.push(node(0, 0));
	visited[0][0] = true;
	ans[now[2]] = true;
	while (!q.empty()) {
		node n = q.front();
		q.pop();
		num A = n.a;
		num B = n.b;
		num C = now[2] - A - B;
		for (num i = 0; i < 6; i++) {
			num next[] = { A,B,C };
			next[Receiver[i]] += next[Sender[i]];
			next[Sender[i]] = 0;
			if (next[Receiver[i]] > now[Receiver[i]]) {
				next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
				next[Receiver[i]] = now[Receiver[i]];
			}
			if (!visited[next[0]][next[1]]) {
				visited[next[0]][next[1]] = true;
				q.push(node(next[0], next[1]));
				if (next[0] == 0) {
					ans[next[2]] = true;
				}
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	cin >> now[0] >> now[1] >> now[2];
	bfs();
	for (num i = 0; i < 201; i++) {
		if (ans[i]) cout << i << " ";
	}
}