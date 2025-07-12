def cnt_pal(line):
    cnt = 0
    for i in range(n, 9):
        sub = line[i - n: i]
        if sub == sub[::-1]:
            cnt += 1

    return cnt

for t in range(1, 11):
    n = int(input())
    board = [list(input()) for _ in range(8)]

    ans = 0
    # 가로
    for i in range(8):
        line = board[i][:]
        ans += cnt_pal(line)

    # 세로
    board = list(map(list, zip(*board)))
    for i in range(8):
        line = board[i][:]
        ans += cnt_pal(line)
    
    print(f'#{t} {ans}')