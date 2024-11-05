w, h = map(int, input().split())
p, q = map(int, input().split())
t = int(input())

dr = 0
di = [1, 1, -1, 1]
dj = [1, -1, -1, -1]

si, sj = q, p
x = y = 0
for i in range(t):
    ni, nj = si + di[dr], sj + dj[dr]
    if 0 <= ni <= h and 0 <= nj <= w:
        si, sj = ni, nj
    else:
        for j in range(1, 4):
            dr = (dr + j) % 4
            ni, nj = si + di[dr], sj + dj[dr]
            if 0 <= ni <= h and 0 <= nj <= w:
                si, sj = ni, nj
                break
    x, y = sj, si

print(x, y)