T = int(input())
for t in range(1, T + 1):
    N = int(input())
    time = [list(map(int, input().split())) for _ in range(N)]
    
    time.sort(key=lambda x: x[1])
    ans = last = 0
    
    for s, e in time:
        if last <= s:
            ans += 1
            last = e

    print(f'#{t} {ans}')