M, N, K = map(int, input().split())
field = [[0] * N for _ in range(M)]

for _ in range(K):
    sj, si, ej, ei = map(int, input().split())
    for i in range(si, ei):
        for j in range(sj, ej):
            if field[i][j] == 0:
                field[i][j] = 1


def bfs(si, sj):
    q = []
    q.append((si, sj))
    v[si][sj] = 1

    cnt = 1
    while q:
        ci, cj = q.pop(0)

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < M and 0 <= nj < N and field[ni][nj] == 0 and v[ni][nj] == 0:
                v[ni][nj] = 1
                q.append((ni, nj))
                cnt += 1

    return cnt


ans = []
v = [[0] * N for _ in range(M)]
for i in range(M):
    for j in range(N):
        if field[i][j] == 0 and v[i][j] == 0:
            cnt = bfs(i, j)
            ans.append(cnt)


ans.sort()
print(len(ans))
print(*ans)