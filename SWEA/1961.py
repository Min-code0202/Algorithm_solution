def rotate(t):
    result = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            result[i][j] = t[N - 1 - j][i]
            
    return result


T = int(input())
for t in range(1, T + 1):
    N = int(input())
    table = [list(map(int, input().split())) for _ in range(N)]

    t1 = rotate(table)
    t2 = rotate(t1)
    t3 = rotate(t2)

    print(f"#{t}")
    for a, b, c in zip(t1, t2, t3):
        print(f'{"".join(map(str, a))} {"".join(map(str, b))} {"".join(map(str, c))}')