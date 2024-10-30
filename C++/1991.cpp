#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
using namespace std;
typedef int num;

vector<vector<num>> tree;

void preorder(num root) {
	if (root == '.' - 'A') return;
	cout << (char)(root + 'A');
	preorder(tree[root][0]);
	preorder(tree[root][1]);
}
void inorder(num root) {
	if (root == '.' - 'A') return;
	inorder(tree[root][0]);
	cout << (char)(root + 'A');
	inorder(tree[root][1]);
}
void postorder(num root) {
	if (root == '.' - 'A') return;
	postorder(tree[root][0]);
	postorder(tree[root][1]);
	cout << (char)(root + 'A');
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);
	num N;
	cin >> N;
	tree.resize(N);
	char p, l, r;
	for (num i = 0; i < N; i++) {
		cin >> p >> l >> r;
		tree[p - 'A'].push_back(l - 'A');
		tree[p - 'A'].push_back(r - 'A');
	}
	preorder(0);
	cout << "\n";
	inorder(0);
	cout << "\n";
	postorder(0);
}
