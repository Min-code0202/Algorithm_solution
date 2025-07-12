T = int(input())
for t in range(1, T + 1):
    D, L, N = map(int, input().split())

    ans = 0
    cnt = 0
    while cnt < N:
        ans += D + D * cnt * L / 100
        cnt += 1

    print(f'#{t} {int(ans)}')