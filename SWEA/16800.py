T = int(input())
for t in range(1, T + 1):
    N = int(input())
    
    lst = []
    for i in range(1, int(N**0.5) + 1):
        if N%i == 0:
            j = N//i
            lst.append([i, j])

    ans = float('inf')
    for l in lst:
        ans = min(ans, (l[0] - 1) + (l[1] - 1))

    print(f'#{t} {ans}')