T = int(input())
for t in range(1, T + 1):
    N = int(input())
    cnt = 1 + N*4

    p = 0
    for x in range(1, N):
        for y in range(1, N):
            res = x**2 + y**2
            if res <= N**2:
                p += 1

    ans = cnt + p*4
    print(f'#{t} {ans}')