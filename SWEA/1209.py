for _ in range(1, 11):
    t = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]

    mx = 0
    for i in range(100):
        mx = max(mx, sum(arr[i]))

    for i in range(100):
        col = 0
        for j in range(100):
            col += arr[j][i]
            mx = max(mx, col)

    result = 0
    for i in range(100):
        result += arr[i][i]
    mx = max(mx, result)

    result = 0
    for i in range(100):
        result += arr[i][99 - i]
    mx = max(mx, result)

    print(f"#{t} {mx}")