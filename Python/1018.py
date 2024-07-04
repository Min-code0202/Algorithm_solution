# n = column m = row
n, m = map(int, input().split())
board = []
result = []

for _ in range(n):
    board.append(input())

for start_col in range(n - 7):
    for start_row in range(m - 7):
        draw1 = 0 # 시작이 B인 경우
        draw2 = 0 # 시작이 W인 경우

        for col in range(start_col, start_col + 8):
            for row in range(start_row, start_row + 8):
                if (col + row)%2 == 0: # 체스판에서 짝수인 칸
                    if board[col][row] != 'B':
                        draw1 += 1
                    if board[col][row] != 'W':
                        draw2 += 1
                else:
                    if board[col][row] != 'W':
                        draw1 += 1
                    if board[col][row] != 'B':
                        draw2 += 1 
        result.append(draw1)
        result.append(draw2)

print(min(result))