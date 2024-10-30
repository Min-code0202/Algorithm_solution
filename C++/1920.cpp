#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef  long long num;

static vector<num> A;

num binary_search(num target) {
	num start = 0;
	num end = A.size() - 1;
	num mid, midV;
	while (start <= end) {
		mid = (start + end) / 2;
		midV = A[mid];
		if (midV > target)
			end = mid - 1;
		else if (midV < target)
			start = mid + 1;
		else
			return 1;
	}
	return 0;
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	num n, m, target;
	cin >> n;
	A = vector<num>(n, 0);
	for (num i = 0; i < n; i++) cin >> A[i];
	sort(A.begin(), A.end());
	cin >> m;
	while (m--) {
		cin >> target;
		cout << binary_search(target) << "\n";
	}
}