T = int(input())
for t in range(1, T + 1):
    n = sorted(list(map(int, input().split())))
    sub = n[1:9]
    add = sum(sub)
    
    print(f'#{t} {round(add/8)}')