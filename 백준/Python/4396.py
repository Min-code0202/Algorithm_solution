n = int(input())
field = [list(input()) for _ in range(n)]
user = [list(input()) for _ in range(n)]

di = [-1, 1, 0, 0, -1, -1, 1, 1]
dj = [0, 0, 1, -1, -1, 1, -1, 1]

result = [['.']*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if user[i][j] == 'x':
            cnt = 0
            for k in range(8):
                ni, nj = i + di[k], j + dj[k]
                if 0 <= ni < n and 0 <= nj < n and field[ni][nj] == '*':
                    cnt += 1

            result[i][j] = str(cnt) if result[i][j] != '*' else '*'

            if field[i][j] == '*':
                for c in range(n):
                    for r in range(n):
                        if field[c][r] == '*':
                            result[c][r] = '*'

for l in result:
    print(*l, sep='')