def bfs(si, sj):
    q = []
    q.append((si, sj))
    v[si][sj] = 1

    while q:
        ci, cj = q.pop(0)
        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < M and v[ni][nj] == 0 and field[ni][nj] == 1:
                q.append((ni, nj))
                v[ni][nj] = 1


T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    field = [[0] * M for _ in range(N)]
    for _ in range(K):
        j, i = map(int, input().split())
        field[i][j] = 1

    cnt = 0
    v = [[0] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if field[i][j] == 1 and v[i][j] == 0:
                bfs(i, j)
                cnt += 1

    print(cnt)
