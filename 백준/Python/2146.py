from collections import deque

N = int(input())
field = [list(map(int, input().split())) for _ in range(N)]


def search(si, sj, island):
    q = deque()
    q.append((si, sj))
    f[si][sj] = island

    while q:
        ci, cj = q.popleft()

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < N and f[ni][nj] == 0 and field[ni][nj] == 1:
                f[ni][nj] = island
                q.append((ni, nj))


f = [[0] * N for _ in range(N)]
island = 1
for i in range(N):
    for j in range(N):
        if field[i][j] == 1 and f[i][j] == 0:
            search(i, j, island)
            island += 1


def bfs(si, sj, n):
    q = deque()
    q.append((si, sj))
    v = [[0] * N for _ in range(N)]
    v[si][sj] = 1
    v_island = []
    v_island.append(n)

    distance = []
    while q:
        ci, cj = q.popleft()
        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < N and v[ni][nj] == 0 and (f[ni][nj] == 0 or f[ni][nj] == n):
                v[ni][nj] = v[ci][cj] + 1
                q.append((ni, nj))
            elif (
                0 <= ni < N
                and 0 <= nj < N
                and v[ni][nj] == 0
                and f[ni][nj] not in v_island
            ):
                v[ni][nj] = v[ci][cj] + 1
                v_island.append(f[ni][nj])
                distance.append(abs(v[si][sj] - v[ni][nj]))

    return distance


least = float("inf")
for i in range(N):
    for j in range(N):
        if f[i][j] != 0:
            result = bfs(i, j, f[i][j])
            result.sort()
            least = min(least, result[0])

print(least - 1)