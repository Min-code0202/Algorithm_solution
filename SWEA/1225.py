for _ in range(10):
    T = int(input())
    data = list(map(int, input().split()))
    q = []
    for d in data:
        q.append(d)

    tried = True
    while tried:
        for i in range(1, 6):
            x = q.pop(0)
            n = x - i if x - i > 0 else 0
            q.append(n)
            if n == 0:
                tried = False
                break

    print(f'#{T} {" ".join(map(str, q))}')
