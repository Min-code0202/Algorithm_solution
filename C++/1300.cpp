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
		for (num i = 1; i <= n; i++) { // i행에 mid보다 작은 수가 몇개인지를 행 단위로 계산.
			// mid/i >= n 이면 i행의 모든 열은 k보다 mid보다 작다는 의미. (n개)
			// mid/i < n 이면 i행에서 mid/i 개만 mid보다 작다는 의미.
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