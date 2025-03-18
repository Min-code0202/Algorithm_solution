T = int(input())

for _ in range(T):
    n, d = map(int, input().split())
    if d < 0:
        d = d + 360
    d = d // 45
    field = [list(map(int, input().split())) for _ in range(n)]

    for _ in range(d):
        sub_field = [field[i][:] for i in range(n)]
        # 가운데 열
        for i in range(n):
            sub_field[i][n//2] = field[i][i]

        # 가운데 행
        for i in range(n):
            sub_field[n//2][i] = field[n - 1 - i][i]

        # 주대각선
        for i in range(n):
            sub_field[i][i] = field[n//2][i]

        # 부대각선
        for i in range(n):
            sub_field[i][n - 1 - i] = field[i][n//2]

        field = [sub_field[i][:] for i in range(n)]

    for row in field:
        print(*row)