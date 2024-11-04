def count(board):
    max_cnt = 1
    
    # 행 검사 
    for i in range(len(board)):
        cnt = 1
        for j in range(1, len(board)):
            if board[i][j] == board[i][j - 1]:
                cnt += 1
                max_cnt = max(max_cnt, cnt)
            else:
                cnt = 1
    
    # 열 검사 
    for j in range(len(board)):
        cnt = 1
        for i in range(1, len(board)):
            if board[i][j] == board[i - 1][j]:
                cnt += 1
                max_cnt = max(max_cnt, cnt)
            else:
                cnt = 1

    return max_cnt


def solve(board):
    max_cnt = 0
    for i in range(N):
        for j in range(N - 1):
            board[i][j], board[i][j + 1] = board[i][j + 1], board[i][j]
            max_cnt = max(max_cnt, count(board))
            board[i][j], board[i][j + 1] = board[i][j + 1], board[i][j]

    for i in range(N - 1):
        for j in range(N):
            board[i][j], board[i + 1][j] = board[i + 1][j], board[i][j]
            max_cnt = max(max_cnt, count(board))
            board[i][j], board[i + 1][j] = board[i + 1][j], board[i][j]

    return max_cnt


N = int(input())
board = [list(input()) for _ in range(N)]

ans = solve(board)
print(ans)