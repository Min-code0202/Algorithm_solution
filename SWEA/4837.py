T = int(input())

def iterative_dfs(N, K):
    global ans
    stack = [(1, 0, 0)]  # (현재 값 c, 선택된 개수 cnt, 선택된 값들의 합 sm)
    
    while stack:
        c, cnt, sm = stack.pop()
        
        if cnt > N or sm > K:
            continue
        if c > 12:
            if cnt == N and sm == K:
                ans += 1
            continue

        # c를 선택하지 않는 경우
        stack.append((c + 1, cnt, sm))
        
        # c를 선택하는 경우
        stack.append((c + 1, cnt + 1, sm + c))

for t in range(1, T + 1):
    N, K = map(int, input().split())

    ans = 0
    iterative_dfs(N, K)

    print(f'#{t} {ans}')