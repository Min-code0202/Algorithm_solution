M, N, H = map(int, input().split())
box = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]


def bfs():
    q = []
    v = [[[0] * M for _ in range(N)] for _ in range(H)]
    cnt = 0
    
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if box[h][i][j] == 1:
                    q.append((h, i, j))
                    v[h][i][j] = 1
                elif box[h][i][j] == 0:
                    cnt += 1

    while q:
        ch, ci, cj = q.pop(0)
        
        for dh, di, dj in ((1, 0, 0), (-1, 0, 0), (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)):
            nh, ni, nj = ch + dh, ci + di, cj + dj
            if 0 <= nh < H and 0 <= ni < N and 0 <= nj < M and box[nh][ni][nj] == 0 and v[nh][ni][nj] == 0:
                q.append((nh, ni, nj))
                v[nh][ni][nj] = v[ch][ci][cj] + 1
                cnt -= 1
            
        
    if cnt == 0:
        return v[ch][ci][cj] - 1     
            
    return -1


ans = bfs()
print(ans)