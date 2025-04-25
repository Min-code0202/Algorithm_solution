T = int(input())
for t in range(1, T + 1):
	N, M = map(int, input().split())
	w = list(map(int, input().split()))

	mx = 0
	for i in range(N - 1):
		for j in range(i + 1, N):
			sm = w[i] + w[j]
			if sm <= M:
				mx = max(mx, sm)

	print(f'#{t} {mx}')