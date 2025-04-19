T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    w = sorted(list(map(int, input().split())), reverse=True)
    t = sorted(list(map(int, input().split())), reverse=True)

    ans = 0
    for i in range(M):
        for j in range(N):
            if t[i] >= w[j]:
                t[i] = 0
                ans += w[j]
                w[j] = float('inf')
                break
    
    print(f'#{tc} {ans}')