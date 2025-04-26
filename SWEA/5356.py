T = int(input())
for t in range(1, T + 1):
	lst = [[] for _ in range(5)]
	for i in range(5):
		lst[i] = list(map(str, input()))

	N = 0
	for l in lst:
		N = max(N, len(l))

	ans = ''
	for i in range(N):
		for j in range(5):
			n = len(lst[j])
			if i < n:
				ans += lst[j][i]

	print(f'#{t} {ans}')