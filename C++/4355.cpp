#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <numeric>
using namespace std;
typedef long long num;

num euler(num n)
{
	num result = n;
	for (num i = 2; i * i <= n; i++)
	{
		if (n % i == 0) {
			result = result - (result / i);
			while (n % i == 0) n /= i;
		}
	}
	if (n > 1) result = result - (result / n);
	return result;
}

int main()
{
	num n;

	while (true) {
		cin >> n;
		if (n == 0) break;
		else if (n == 1)  cout << 0 << "\n";
		else cout << euler(n) << "\n";
	}
}