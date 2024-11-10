N, K = map(int, input().split())


def bfs(N):
    q = []
    v = [0] * 100001
    q.append(N)
    v[N] = 1

    while q:
        ci = q.pop(0)
        if ci == K:
            return v[ci] - 1

        for di in (-1, 1, 2):
            if di == 2:
                ni = ci * di
            else:
                ni = ci + di

            if 0 <= ni < 100001 and v[ni] == 0:
                v[ni] = v[ci] + 1
                q.append(ni)


ans = bfs(N)
print(ans)