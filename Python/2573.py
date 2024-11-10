from collections import deque

N, M = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(N)]


def bfs(si, sj):
    q = deque()
    v[si][sj] = 1
    q.append((si, sj))

    while q:
        cnt = 0
        ci, cj = q.popleft()
        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < M:
                if field[ni][nj] == 0:
                    cnt += 1
                elif field[ni][nj] > 0 and v[ni][nj] == 0:
                    q.append((ni, nj))
                    v[ni][nj] = 1
        
        sub_field[ci][cj] = cnt


tried = 0
while True:
    v = [[0] * M for _ in range(N)]
    sub_field = [[0] * M for _ in range(N)]
    ice_positions = [(i, j) for i in range(N) for j in range(M) if field[i][j] > 0]

    cnt = 0
    for i, j in ice_positions:
        if v[i][j] == 0:
            bfs(i, j)
            cnt += 1

    # 한 번에 `field` 업데이트
    for i in range(N):
        for j in range(M):
            field[i][j] = max(field[i][j] - sub_field[i][j], 0)

    tried += 1
    if cnt >= 2:
        break
    if cnt == 0:  # 빙하가 다 녹은 경우
        tried = 1
        break

print(tried - 1)