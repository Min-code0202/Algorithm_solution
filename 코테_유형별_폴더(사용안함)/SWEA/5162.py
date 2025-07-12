T = int(input())
for t in range(1, T + 1):
    A, B, C = map(int, input().split())

    mn = min(A, B)
    mx = max(A, B)
    ans = C // mn
    C = C - ans * mn
    
    if C > mx:
        ans += C // mx
    
    print(f'#{t} {ans}')
