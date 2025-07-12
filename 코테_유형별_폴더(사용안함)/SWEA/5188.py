T = int(input())
for t in range(1, T + 1):
	N = int(input())
	arr = [[0] * (N + 1)] + [[0] + list(map(int, input().split())) for _ in range(N)]
	prefix = [[0] * (N + 1) for _ in range(N + 1)]
	
	for i in range(1, N + 1):
		for j in range(1, N + 1):
			if i == 1 or j == 1:
				prefix[i][j] = arr[i][j] + prefix[i - 1][j] + prefix[i][j - 1]
			else:
				sub = prefix[i - 1][j] if prefix[i - 1][j] <= prefix[i][j - 1] else prefix[i][j - 1]
				prefix[i][j] = arr[i][j] + sub

	ans = prefix[N][N]
	print(f'#{t} {ans}')