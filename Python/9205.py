T = int(input())


def bfs(sj, si, ej, ei):
    q = []
    v = [0] * N

    q.append((sj, si))

    while q:
        cj, ci = q.pop(0)
        if abs(cj - ej) + abs(ci - ei) <= 1000:
            return "happy"

        for i in range(N):
            nj, ni = lst[i]
            if abs(cj - nj) + abs(ci - ni) <= 1000 and v[i] == 0:
                q.append((nj, ni))
                v[i] = 1

    return "sad"


for _ in range(T):
    N = int(input())
    sj, si = map(int, input().split())
    lst = []
    for _ in range(N):
        mj, mi = map(int, input().split())
        lst.append((mj, mi))

    ej, ei = map(int, input().split())

    ans = bfs(sj, si, ej, ei)
    print(ans)