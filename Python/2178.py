N, M = map(int, input().split())
field = [list(map(int, input().strip())) for _ in range(N)]


def bfs(si, sj, ei, ej):
    q = []
    v = [[0] * M for _ in range(N)]
    v[si][sj] = 1
    q.append((si, sj))

    while q:
        ci, cj = q.pop(0)
        if (ci, cj) == (ei, ej):
            return v[ci][cj]

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < M and field[ni][nj] == 1 and v[ni][nj] == 0:
                v[ni][nj] = v[ci][cj] + 1
                q.append((ni, nj))


ans = bfs(0, 0, N - 1, M - 1)
print(ans)