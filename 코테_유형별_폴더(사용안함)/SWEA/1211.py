for t in range(1, 11):
    _ = int(input())
    ladder = [[0] + list(map(int, input().split())) + [0] for _ in range(100)]
     
    min_cnt = float('inf')
    for sj in range(1, 101):
        if ladder[0][sj] == 0:
            continue
        cj = sj
        cnt = dr = ci = 0
        while ci < 99:
            cnt += 1
            if dr == 0:
                ci += 1
                if ladder[ci][cj - 1] == 1:
                    dr = -1
                elif ladder[ci][cj + 1] == 1:
                    dr = 1
            else:
                cj += dr
                if ladder[ci][cj+dr] == 0:
                    dr = 0
                    
        if min_cnt >= cnt:
            min_cnt, ans = cnt, sj - 1
    
    print(f'#{t} {ans}')