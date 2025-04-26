from collections import deque

N, M = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(N)]
visit = [[-1] * M for _ in range(N)]  # 방문하지 않은 곳을 -1로 설정

def bfs(start):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    q = deque([start])  # 큐에 시작점 추가
    visit[start[0]][start[1]] = 0  # 시작점 방문 표시

    while q:
        x, y = q.popleft()  # BFS에서는 popleft() 사용
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if visit[nx][ny] == -1 and field[nx][ny] == 1:  # 방문하지 않은 땅
                    visit[nx][ny] = visit[x][y] + 1
                    q.append((nx, ny))

# 시작점 찾기
start = None
for i in range(N):
    for j in range(M):
        if field[i][j] == 2:
            start = (i, j)

if start:  # 시작점이 존재할 때만 BFS 실행
    bfs(start)

# 결과 출력
for i in range(N):
    for j in range(M):
        print(visit[i][j] if field[i][j] != 0 else 0, end=' ')  # 장애물(0)은 그대로 0 출력
    print()
