T = int(input())
for t in range(1, T + 1):
    N = int(input())
    field = [list(map(int, input())) for _ in range(N)]

    ans = 0
    for i in range(N // 2 + 1):
        for j in range((N // 2) - i, N + i - (N // 2)):
            if field[i][j] == 0:
                continue
            ans += field[i][j]

    for i in range(N // 2 + 1, N):
        for j in range(i - (N // 2), N - i + (N // 2)):
            if field[i][j] == 0:
                continue
            ans += field[i][j]

    print(f"#{t} {ans}")
