#include <iostream>
#include <algorithm>
using namespace std;

void Add(int* arr, char c)
{
	if (c == 'A')
		arr[0]++;
	else if (c == 'C')
		arr[1]++;
	else if (c == 'G')
		arr[2]++;
	else if (c == 'T')
		arr[3]++;
}
void Remove(int* arr, char c)
{
	if (c == 'A')
		arr[0]--;
	else if (c == 'C')
		arr[1]--;
	else if (c == 'G')
		arr[2]--;
	else if (c == 'T')
		arr[3]--;
}
bool IsDNA(int* arr, int* check)
{
	for (int i = 0; i < 4; i++)
	{
		if (arr[i] < check[i])
			return false;
	}
	return true;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cout.tie(0);
	cin.tie(0);

	int n, m;
	string dna;
	int check[4];
	int current[4];
	int cnt = 0;
	cin >> n >> m;
	cin >> dna;
	for (int i = 0; i < 4; i++)
	{
		cin >> check[i];
		current[i] = 0;
	}

	for (int i = 0; i < m; i++)
	{
		Add(current, dna[i]);
	}
	if (IsDNA(current, check))
		cnt++;
	for (int i = m; i < n; i++)
	{
		int j = i - m;
		Add(current, dna[i]);
		Remove(current, dna[j]);
		if (IsDNA(current, check))
			cnt++;
	}
	cout << cnt;
}