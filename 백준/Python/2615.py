field = [list(map(int, input().split())) for _ in range(19)]

# 방향: (가로, 세로, 대각선 ↘, 대각선 ↗)
dx = [0, 1, 1, -1]
dy = [1, 0, 1, 1]

def check_winner(x, y, color):
    """
    주어진 (x, y) 위치에서 가로, 세로, 대각선 방향으로 5개 연속인지 확인
    단, 정확히 5개여야 하고, 6목 이상이면 안 됨
    """
    for d in range(4):  # 4가지 방향 탐색
        count = 1
        px, py = x, y  # 시작 좌표 저장

        # 한쪽 방향으로 탐색 (5개 연속 확인)
        while True:
            nx, ny = px + dx[d], py + dy[d]
            if 0 <= nx < 19 and 0 <= ny < 19 and field[nx][ny] == color:
                count += 1
                px, py = nx, ny
            else:
                break

        px, py = x, y  # 다시 원래 위치로 복귀

        # 반대 방향으로 탐색 (육목 방지)
        while True:
            nx, ny = px - dx[d], py - dy[d]
            if 0 <= nx < 19 and 0 <= ny < 19 and field[nx][ny] == color:
                count += 1
                px, py = nx, ny
            else:
                break

        # 정확히 5개인 경우만 승리 인정
        if count == 5:
            # 가장 왼쪽(또는 가장 위쪽) 돌 찾기
            start_x, start_y = x, y
            while True:
                nx, ny = start_x - dx[d], start_y - dy[d]
                if 0 <= nx < 19 and 0 <= ny < 19 and field[nx][ny] == color:
                    start_x, start_y = nx, ny
                else:
                    break
            return color, start_x + 1, start_y + 1  # 1부터 시작하는 좌표 반환

    return None  # 승리 조건을 만족하지 않음

winner = None
for i in range(19):
    for j in range(19):
        if field[i][j] != 0:  # 바둑알이 있는 경우만 체크
            result = check_winner(i, j, field[i][j])
            if result:
                winner = result
                break  # 승자가 결정되면 즉시 종료
    if winner:
        break

if winner:
    print(winner[0])  # 승리한 색 출력
    print(winner[1], winner[2])  # 가장 왼쪽 또는 위쪽 바둑알의 좌표 출력
else:
    print(0)  # 승자가 없는 경우