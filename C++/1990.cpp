#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <string>
using namespace std;
typedef int num;
num a, b;
vector<num> prime;
void eratos() {
	vector<bool> isprime(b + 1, 1);
	for (num i = 2; i * i <= b; i++) {
		if (!isprime[i]) continue;
		for (num j = i * i; j <= b; j += i) {
			isprime[j] = 0;
		}
	}
	for (num i = a; i <= b; i++)
		if (isprime[i]) prime.push_back(i);
}
bool is_palindrome(const string& str) {
	num st{}, en = (num)str.size() - 1;
	while (st < en) {
		if (str[st++] != str[en--]) return 0;
	}
	return 1;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	cin >> a >> b;
	eratos();
	for (auto& val : prime) {
		if (is_palindrome(to_string(val))) cout << val << "\n";
	}
	cout << -1;
}