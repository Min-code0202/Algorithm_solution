from collections import deque

R, C = map(int, input().split())
field = [list(input().strip()) for _ in range(R)]
v = [[0] * C for _ in range(R)]
w = [[0] * C for _ in range(R)]

def bfs(si, sj, ei, ej):
    sq = deque()  # 고슴도치 큐
    wq = deque()            # 홍수 큐
    
    sq.append((si, sj)) 
    v[si][sj] = 1

    # 초기 홍수 위치를 큐에 추가
    for i in range(R):
        for j in range(C):
            if field[i][j] == "*":
                wq.append((i, j))
                w[i][j] = 1

    while sq:
        # 1. 홍수 확장
        for _ in range(len(wq)):
            ci, cj = wq.popleft()
            for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                ni, nj = ci + di, cj + dj
                if 0 <= ni < R and 0 <= nj < C and field[ni][nj] == "." and w[ni][nj] == 0:
                    field[ni][nj] = "*"
                    w[ni][nj] = 1
                    wq.append((ni, nj))

        # 2. 고슴도치 이동
        for _ in range(len(sq)):
            ci, cj = sq.popleft()
            if ci == ei and cj == ej:
                return v[ci][cj] - 1

            for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                ni, nj = ci + di, cj + dj
                if 0 <= ni < R and 0 <= nj < C and v[ni][nj] == 0 and field[ni][nj] != "*" and field[ni][nj] != "X":
                    v[ni][nj] = v[ci][cj] + 1
                    sq.append((ni, nj))

    return "KAKTUS"

def solve():
    si = sj = ei = ej = -1
    for i in range(R):
        for j in range(C):
            if field[i][j] == "S":
                si, sj = i, j
            elif field[i][j] == "D":
                ei, ej = i, j

    return bfs(si, sj, ei, ej)

# 결과 출력
ans = solve()
print(ans)