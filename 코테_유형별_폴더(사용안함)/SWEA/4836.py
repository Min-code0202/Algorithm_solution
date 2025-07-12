T = int(input())

def scatch(r1, c1, r2, c2, color):
    global cnt

    for i in range(r1, r2 + 1):
        for j in range(c1, c2 + 1):
            if board[i][j] == 0:
                board[i][j] = color
            else:
                if board[i][j] != color:
                    board[i][j] = color
                    cnt += 1

for t in range(1, T + 1):
    N = int(input())
    board = [[0] * 10 for _ in range(10)]
    arr = [list(map(int, input().split())) for _ in range(N)]
    
    cnt = 0
    for area in arr:
        r1, c1, r2, c2, color = area
        if color == 1:
            scatch(r1, c1, r2, c2, color)
        elif color == 2:
            scatch(r1, c1, r2, c2, color)


    print(f'#{t} {cnt}')