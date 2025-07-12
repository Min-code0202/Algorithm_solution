T = int(input())
for t in range(1, T + 1):
    N = int(input())
    lst = [list(map(int, input().split())) for _ in range(N)]

    ans = 0
    for i in range(len(lst) - 1):
        for j in range(i + 1, len(lst)):
            A1, B1 = lst[i][0], lst[i][1]
            A2, B2 = lst[j][0], lst[j][1]

            if (A1 > A2 and B1 < B2) or (A1 < A2 and B1 > B2):
                ans += 1

    print(f'#{t} {ans}')