#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef long long num;

struct node {
	num a;
	num b;
	num c;
};

vector<node> A[10];
num m_lcm = 1;
bool visited[10];
num D[10];

void dfs(num node);

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	num N;
	num a, b, p, q;
	cin >> N;
	for (num i = 1; i < N; i++) {
		cin >> a >> b >> p >> q;
		A[a].push_back(node(b, p, q));
		A[b].push_back(node(a, q, p));
		m_lcm *= lcm(p, q);
	}
	D[0] = m_lcm;
	dfs(0);
	num m_gcd = D[0];
	for (num i = 1; i < N; i++){
		m_gcd = gcd(m_gcd,D[i]);
	}
	for (num i = 0; i < N; i++){
		cout << D[i] / m_gcd << " ";
	}

}

void dfs(num index) {
	visited[index] = true;
	for (node i : A[index]) {
		num next = i.a;
		if (visited[next]) continue;
		D[next] = D[index] * i.c / i.b;
		dfs(next);
	}
}