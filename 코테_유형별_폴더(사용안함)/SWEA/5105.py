T = int(input())

def bfs(s):
	q = []
	q.append(s)
	v[s[0]][s[1]] = 1

	while q:
		ci, cj = q.pop(0)
		if arr[ci][cj] == '3':
			break

		for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
			ni, nj = ci + di, cj + dj
			if 0 <= ni < N and 0 <= nj < N and v[ni][nj] == 0 and arr[ni][nj] != '1':
				v[ni][nj] = v[ci][cj] + 1
				q.append((ni, nj))
	

for t in range(1, T + 1):
	N = int(input())
	arr = [list(map(str, input())) for _ in range(N)]

	s = e = 0
	for i in range(N):
		for j in range(N):
			if arr[i][j] == '2':
				s = (i, j)
			elif arr[i][j] == '3':
				e = (i, j)

	v = [[0]*N for _ in range(N)]
	bfs(s)
	ans = v[e[0]][e[1]] - 2 if v[e[0]][e[1]] > 0 else 0

	print(f'#{t} {ans}')