N = int(input())
field = [list(map(int, input().split())) for _ in range(N)]


def bfs(si, sj):
    q = []
    q.append((si, sj))
    v[si][sj] = 1

    while q:
        ci, cj = q.pop(0)
        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < N and field[ni][nj] > h and v[ni][nj] == 0:
                v[ni][nj] = 1
                q.append((ni, nj))

area = []
for h in range(100):
    for i in range(N):
        for j in range(N):
            if field[i][j] <= h:
                v[i][j] = 1

    cnt = 0
    v = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if field[i][j] > h and v[i][j] == 0:
                bfs(i, j)
                cnt += 1
    area.append(cnt)

print(max(area))