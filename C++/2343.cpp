#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef  long long num;


int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	num n, m;
	cin >> n >> m;
	num s = 0;
	num e = 0;
	vector<num> vec(n);
	for (num i = 0; i < n; i++) {
		cin >> vec[i];
		if (s < vec[i]) s = vec[i];
		e += vec[i];
	}

	while (s <= e) {
		num mid = (s + e) / 2;
		num sum = 0;
		num count = 0;
		for (num i = 0; i < n; i++) {
			if (sum + vec[i] > mid) {
				count++;
				sum = 0;
			}
			sum += vec[i];
		}
		if (sum != 0)
			count++;
		if (count > m)
			s = mid + 1;
		else
			e = mid - 1;
	}
	cout << s << "\n";
}