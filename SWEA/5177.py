T = int(input())
for t in range(1, T + 1):
    N = int(input())
    lst = list(map(int, input().split()))

    h = [0] * (N + 1)
    last = 0

    for l in lst:
        last += 1
        h[last] = l

        child = last
        while child//2 and h[child] < h[child//2]:
            h[child], h[child//2] = h[child//2], h[child]
            child //= 2

    child = last//2
    ans = 0
    while child:
        ans += h[child]
        child //= 2

    print(f'#{t} {ans}')