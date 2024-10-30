#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <string>
#include <numeric>
using namespace std;
typedef int num;

int main()
{
	num n, m;
	cin >> n >> m;

	cout << m - gcd(n, m);
}