T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    arr = [[0] * (N + 1) for _ in range(N + 1)]
    m = N // 2
    arr[m][m] = arr[m + 1][m + 1] = 2
    arr[m][m + 1] = arr[m + 1][m] = 1

    for _ in range(M):
        si, sj, d = map(int, input().split())
        arr[si][sj] = d
        for di, dj in (
            (-1, -1),
            (-1, 0),
            (-1, 1),
            (1, -1),
            (1, 0),
            (1, 1),
            (0, -1),
            (0, 1),
        ):
            r = []
            for mul in range(1, N):
                ni, nj = si + di * mul, sj + dj * mul
                if 1 <= ni <= N and 1 <= nj <= N:
                    if arr[ni][nj] == 0:
                        break
                    elif arr[ni][nj] == d:
                        while r:
                            ti, tj = r.pop()
                            arr[ti][tj] = d
                        break
                    else:
                        r.append((ni, nj))
                else:
                    break

    bcnt = wcnt = 0
    for lst in arr:
        bcnt += lst.count(1)
        wcnt += lst.count(2)

    print(f"#{test_case} {bcnt} {wcnt}")
