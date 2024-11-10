from collections import deque

N, M = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(N)]


def bfs(si, sj, v):
    q = deque()
    v[si][sj] = 1
    q.append((si, sj))

    while q:
        ci, cj = q.popleft()

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if v[ni][nj] == 0 and field[ni][nj] > 0:
                q.append((ni, nj))
                v[ni][nj] = 1


def solve():
    for year in range(1, 900000):
        sub_field = [[0] * M for _ in range(N)]
        for i in range(N):
            for j in range(M):
                if field[i][j] == 0:
                    continue
                for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                    ni, nj = i + di, j + dj
                    if field[ni][nj] == 0:
                        sub_field[i][j] += 1

        for i in range(N):
            for j in range(M):
                if sub_field[i][j] != 0:
                    field[i][j] = max(field[i][j] - sub_field[i][j], 0)

        v = [[0] * M for _ in range(N)]
        cnt = 0
        for i in range(N):
            for j in range(M):
                if v[i][j] == 0 and field[i][j] > 0:
                    bfs(i, j, v)
                    cnt += 1
                    if cnt > 1:
                        return year
        if cnt == 0:
            return 0
    return -1


ans = solve()
print(ans)