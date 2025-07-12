N = int(input())
field = [list(map(int, input().strip())) for _ in range(N)]
v = [[0] * N for _ in range(N)]
ans = []


def bfs(si, sj):
    q = []
    q.append((si, sj))
    v[si][sj] = 1
    cnt = 1

    while q:
        ci, cj = q.pop(0)
        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < N and field[ni][nj] == 1 and v[ni][nj] == 0:
                q.append((ni, nj))
                v[ni][nj] = 1
                cnt += 1

    return cnt


for i in range(N):
    for j in range(N):
        if field[i][j] == 1 and v[i][j] == 0:
            ans.append(bfs(i, j))

ans.sort()
print(len(ans), *ans, sep="\n")