T = int(input())

for t in range(1, T + 1):
    N, *M = list(map(int, input().split()))
    M = [0] + M
    ni = N

    ans = 0
    while True:
        for i in range(1, ni):
            if ni - i <= M[i]:
                ni = i
                ans += 1
                break
        if ni == 1:
            break

    print(f'#{t} {ans - 1}')
