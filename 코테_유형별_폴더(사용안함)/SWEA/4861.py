T = int(input())
for t in range(1, T + 1):
	N, M = map(int, input().split())
	arr = [list(map(str, input())) for _ in range(N)]
	t_arr = list(map(list, zip(*arr)))

	ans = ''
	for i in range(N):
		for j in range(N - M + 1):
			sub = arr[i][j:j + M]
			if sub == sub[::-1]:
				ans = sub

	for i in range(N):
		for j in range(N - M + 1):
			sub = t_arr[i][j:j + M]
			if sub == sub[::-1]:
				ans = sub

	print(f"#{t} {''.join(map(str, ans))}")