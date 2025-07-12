T = int(input())
for t in range(1, T + 1):
    n = int(input())
    a = list(map(int, input().split()))
    
    idx = []
    for i in range(7):
        if a[i] == 1:
            idx.append(i)

    ans = float('inf')
    for i in idx:
        cnt = day = 0
        while True:
            day += 1
            if a[i] == 1:
                cnt += 1
            if cnt == n:
                ans = min(ans, day)
                break
            
            i = (i + 1)%7

    print(f'#{t} {ans}')