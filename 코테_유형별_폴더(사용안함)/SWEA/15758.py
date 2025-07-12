TC = int(input())
for t in range(1, TC + 1):
    S, T = input().split()

    S = (S * 2500)[:2500]
    T = (T * 2500)[:2500]
    
    ans = 'yes' if S == T else 'no'
    
    print(f'#{t} {ans}')
