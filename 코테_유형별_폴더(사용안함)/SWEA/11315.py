def solve():
    for si in range(N):
        for sj in range(N):
            for di, dj in ((0, 1), (1, 0), (1, 1), (-1, 1)):
                for mul in range(5):
                    ni, nj = si + di * mul, sj + dj * mul
                    if 0 <= ni < N and 0 <= nj < N and field[ni][nj] == "o":
                        pass
                    else:
                        break
                else:
                    return "YES"

    return "NO"


T = int(input())
for t in range(1, T + 1):
    N = int(input())
    field = [list(map(str, input())) for _ in range(N)]

    ans = solve()
    print(f"#{t} {ans}")