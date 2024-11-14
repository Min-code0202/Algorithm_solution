def bfs(si, sj, ei, ej):
    q = []
    v = [[0] * I for _ in range(I)]
    q.append((si, sj))
    v[si][sj] = 1

    while q:
        ci, cj = q.pop(0)
        if ci == ei and cj == ej:
            return v[ci][cj] - 1

        for di, dj in (
            (-1, -2),
            (-2, -1),
            (-2, 1),
            (-1, 2),
            (1, 2),
            (2, 1),
            (2, -1),
            (1, -2),
        ):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < I and 0 <= nj < I and v[ni][nj] == 0:
                v[ni][nj] = v[ci][cj] + 1
                q.append((ni, nj))


T = int(input())
for _ in range(T):
    I = int(input())
    chess = [[0] * I for _ in range(I)]
    si, sj = map(int, input().split())
    ei, ej = map(int, input().split())

    ans = bfs(si, sj, ei, ej)
    print(ans)