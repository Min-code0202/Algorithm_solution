T = int(input())
for t in range(1, T + 1):
    N = int(input())
    lst = list(map(int, input().split()))

    avg = sum(lst)//N
    ans = 0
    for i in range(N):
        if lst[i] <= avg:
            ans += 1

    print(f'#{t} {ans}')