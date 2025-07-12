K = int(input())
W, H = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(H)]

m = [(1, 0), (-1, 0), (0, 1), (0, -1)]
h = [(-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2)]


def bfs(jump):
    q = []
    v = [[[0] * (K + 1) for _ in range(W)] for _ in range(H)]

    v[0][0][0] = 1
    q.append((0, 0, 0))

    while q:
        ci, cj, ch = q.pop(0)
        if ci == H - 1 and cj == W - 1:
            return v[ci][cj][ch] - 1

        for di, dj in m:
            ni, nj = ci + di, cj + dj
            if 0 <= ni < H and 0 <= nj < W and v[ni][nj][ch] == 0 and field[ni][nj] == 0:
                v[ni][nj][ch] = v[ci][cj][ch] + 1
                q.append((ni, nj, ch))
                
        if ch < K:
            for di, dj in h:
                ni, nj = ci + di, cj + dj
                if 0 <= ni < H and 0 <= nj < W and field[ni][nj] == 0 and v[ni][nj][ch + 1] == 0:
                    v[ni][nj][ch + 1] = v[ci][cj][ch] + 1
                    q.append((ni, nj, ch + 1))
        
    return -1


ans = bfs(K)
print(ans)