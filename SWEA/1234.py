for t in range(1, 11):
    N, st = map(str, input().split())
    N = int(N)
    lst = list(st)
    
    while True:
        cnt = 0
        sub = []
        for i in range(len(lst)):
            if sub and sub[-1] == lst[i]:
                sub.pop()
            else:
                sub.append(lst[i])
                cnt += 1
        
        lst = sub.copy()
        if cnt == len(lst):
            break

    ans = ''.join(map(str, lst))
    print(f'#{t} {ans}')