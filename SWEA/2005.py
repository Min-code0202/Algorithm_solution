T = int(input())
for t in range(1, T + 1):
    N = int(input())

    field = [[0] * N for _ in range(N)]
    for i in range(N):
        field[i][0] = 1
        field[i][i] = 1 

    for i in range(1, N):
        for j in range(1, N):
            if field[i][j] == 0:
                field[i][j] = field[i - 1][j - 1] + field[i - 1][j]

    print(f'#{t}')
    for i in range(N):
        print(*field[i][:i + 1])