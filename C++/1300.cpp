#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef  long long num;


int main() {
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	num n, k;
	num result;
	cin >> n >> k;

	num start = 1;
	num end = k;

	while (start <= end) {
		num mid = (start + end) / 2;
		num cnt = 0;
		for (num i = 1; i <= n; i++) { // i�࿡ mid���� ���� ���� ������� �� ������ ���.
			// mid/i >= n �̸� i���� ��� ���� k���� mid���� �۴ٴ� �ǹ�. (n��)
			// mid/i < n �̸� i�࿡�� mid/i ���� mid���� �۴ٴ� �ǹ�.
			cnt += min(mid / i, n);
		}
		if (cnt < k)
			start = mid + 1;
		else {
			end = mid - 1;
			result = mid;
		}
	}
	cout << result;
}