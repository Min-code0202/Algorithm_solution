C, R = map(int, input().split())
K = int(input())


if C * R < K:
    print(0)
else:
    di, dj = [1, 0, -1, 0], [0, 1, 0, -1]
    field = [[1] * (C + 2)] + [[1] + [0] * C + [1] for _ in range(R)] + [[1] * (C + 2)]
    ci, cj, dr = 1, 1, 0

    for n in range(1, K):
        field[ci][cj] = n
        ni, nj = ci + di[dr], cj + dj[dr]
        if field[ni][nj] == 0:
            ci, cj = ni, nj
        else:
            dr = (dr + 1) % 4
            ci, cj = ci + di[dr], cj + dj[dr]

    print(cj, ci)