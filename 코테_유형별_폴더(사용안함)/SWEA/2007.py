T = int(input())
for t in range(1, T + 1):
    st = input()

    pattern = st[0]
    for i in range(1, len(st)):
        if st[i - 1] != st[i]:
            break
        pattern += st[i]



    lst = []
    for i in range(1, len(st)):
        if pattern == st[i:i + len(pattern)]:
            lst.append(i) 

    for i in lst:
        pattern = st[:i]
        if pattern == st[i:i + len(pattern)]:
            break
    
    
    ans = len(pattern)
    print(f'#{t} {ans}')