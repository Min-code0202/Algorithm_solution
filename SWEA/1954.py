T = int(input())
for t in range(1, T + 1):
    N = int(input())
    di = [0, 1, 0, -1]
    dj = [1, 0, -1, 0]

    snail = [[0] * N for _ in range(N)]
    ci, cj, dr = 0, 0, 0
    cnt = 1

    while cnt <= N * N:
        snail[ci][cj] = cnt
        cnt += 1
        
        ni, nj = ci + di[dr], cj + dj[dr]
        if 0 <= ni < N and 0 <= nj < N and snail[ni][nj] == 0:
            ci, cj = ni, nj
        else:
            dr = (dr + 1) % 4
            ci, cj = ci + di[dr], cj + dj[dr]

    print(f'#{t}')
    for s in snail:
        print(' '.join(map(str, s)))
