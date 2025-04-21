T = int(input())
for t in range(1, T + 1):
    E, N = map(int, input().split())
    pair = list(map(int, input().split()))
    tree = [[] for _ in range(0, max(pair) + 1)]

    for i in range(0, len(pair), 2):
        parent, child = pair[i], pair[i + 1]
        tree[parent].append(child)

    cnt = 0
    q = []
    for i in tree[N]:
        q.append(i)
    
    while q:
        parent = q.pop(0)
        cnt += 1
        sub = tree[parent][:]
        
        for s in sub:
            q.append(s)

    print(f'#{t} {cnt + 1}')