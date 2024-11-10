F, S, G, U, D = map(int, input().split())
building = [0] * (F + 1)


def bfs():
    q = []
    building[S] = 1
    q.append(S)

    while q:
        ci = q.pop(0)
        if ci == G:
            return building[ci] - 1

        for ni in (ci + U, ci - D):
            if 1 <= ni <= F and building[ni] == 0:
                building[ni] = building[ci] + 1
                q.append(ni)

    return "use the stairs"


ans = bfs()
print(ans)