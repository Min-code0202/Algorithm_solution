T = int(input())
for t in range(1, T + 1):
    N, K = map(int, input().split())
    puzzle = [list(map(int, input().split())) for _ in range(N)]

    ans = 0
    # 가로 탐색
    for i in range(N):
        cnt = 1
        p = puzzle[i][:]
        for j in range(N):
            if p[j] == 0:
                cnt = 1
            elif p[j] == 1:
                p[j] = cnt
                cnt += 1
        
        for j in range(N):
            if p[j] == K:
                if j == N - 1:
                    ans += 1
                else:
                    if p[j + 1] == 0:
                        ans += 1

    # 세로 탐색
    for i in range(N):
        cnt = 1
        p = []
        for j in range(N):
            p.append(puzzle[j][i])
        
        for j in range(N):
            if p[j] == 0:
                cnt = 1
            elif p[j] == 1:
                p[j] = cnt
                cnt += 1
        
        for j in range(N):
            if p[j] == K:
                if j == N - 1:
                    ans += 1
                else:
                    if p[j + 1] == 0:
                        ans += 1

    print(f'#{t} {ans}')