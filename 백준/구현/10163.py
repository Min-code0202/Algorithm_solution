N = int(input())
field = [[0] * 1001 for _ in range(1001)]
for n in range(1, N + 1):
    a, b, w, h = map(int, input().split())
    for i in range(a, a + h):
        for j in range(b, b + w):
            field[i][j] = n

for n in range(1, N + 1):
    cnt = 0
    for i in range(1001):
        for j in range(1001):
            if field[i][j] == n:
                cnt += 1

    print(cnt)
