N, M = map(int, input().split())
dr = [(-1, 0), (0, 1), (1, 0), (0, -1)]
field = [[] for _ in range(N)]
v = [[0] * M for _ in range(N)]

si, sj, d = map(int, input().split())
for i in range(N):
    field[i] = list(map(int, input().split()))

for i in range(N):
    for j in range(M):
        if field[i][j] == 1:
            v[i][j] = 1


def bfs(si, sj):
    global d

    q = []
    v[si][sj] = 1
    q.append((si, sj))

    pan = 1
    while q:
        ci, cj = q.pop(0)

        cnt = 0
        for di, dj in dr:
            ni, nj = ci + di, cj + dj
            if field[ni][nj] == 1 or v[ni][nj] != 0:
                cnt += 1

        # [1] 청소되지 않은 빈 칸이 없는 경우
        if cnt == 4:
            di, dj = dr[(d + 2) % 4]  # 바라보는 방향 반대로 후진
            ni, nj = ci + di, cj + dj
            if field[ni][nj] == 1:  # 후진할 수 없다면 종료
                return pan
            else:
                if v[ni][nj] == 0:
                    q.append((ni, nj))
                    v[ni][nj] = 1
                    pan += 1
                else:
                    q.append((ni, nj))
                continue
        else:  # [2] 청소되지 않은 빈 칸이 있는 경우
            for _ in range(4):
                d = (4 + (d - 1)) % 4  # 반시계 방향 90도 회전
                di, dj = dr[d]
                ni, nj = ci + di, cj + dj
                if field[ni][nj] == 0 and v[ni][nj] == 0:
                    q.append((ni, nj))
                    v[ni][nj] = 1
                    pan += 1
                    break


ans = bfs(si, sj)
print(ans)