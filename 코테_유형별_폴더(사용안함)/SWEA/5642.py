T = int(input())
for t in range(1, T + 1):
	N = int(input())
	arr = [0] + list(map(int, input().split()))

	dp = [0]*(N + 1)
	if max(arr[1:]) < 0:
		ans = max(arr[1:])
	else:
		for i in range(1, N + 1):
			dp[i] = max(0, dp[i - 1] + arr[i])
		ans = max(dp[1:])

	print(f'#{t} {ans}')
	