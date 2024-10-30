#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef  long long num;


static vector<num> A;
static vector<num> tmp;
static num result;


void merget_sort(int s, int e) {
	if (e - s < 1)
		return;

	num m = s + (e - s) / 2;

	merget_sort(s, m);
	merget_sort(m + 1, e);
	for (num i = s; i <= e; i++) {
		tmp[i] = A[i];
	}
	num k = s;
	num index1 = s;
	num index2 = m + 1;

	while (index1 <= m && index2 <= e) {
		if (tmp[index1] > tmp[index2]) {
			A[k] = tmp[index2];
			result = result + index2 - k;
			k++;
			index2++;
		}
		else {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
	}
	while (index1 <= m) {
		A[k] = tmp[index1];
		k++;
		index1++;
	}
	while (index2 <= e) {
		A[k] = tmp[index2];
		k++;
		index2++;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	num n;
	cin >> n;
	A = vector<num>(n + 1, 0);
	tmp = vector<num>(n + 1, 0);
	for (num i = 1; i <= n; i++) {
		cin >> A[i];
	}
	result = 0;
	merget_sort(1, n);

	cout << result;
}