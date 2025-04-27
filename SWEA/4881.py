T = int(input())

def solve(depth, N, sm):
	global mn
	if sm >= mn:
		return
	if depth == N:
		mn = min(mn, sm)
		return

	for i in range(N):
		if v1[depth] == 0 and v2[i] == 0:
			v1[depth] = v2[i] = 1
			solve(depth + 1, N, sm + arr[depth][i])
			v1[depth] = v2[i] = 0


for t in range(1, T + 1):
	N = int(input())
	arr = [list(map(int, input().split())) for _ in range(N)]
	v1 = [0]*N # 같은 행에 1 여부
	v2 = [0]*N # 같은 열에 1 여부

	mn = float('inf')
	solve(0, N, 0)

	print(f'#{t} {mn}')