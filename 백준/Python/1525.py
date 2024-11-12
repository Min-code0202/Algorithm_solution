from collections import deque

puzzle = ""
for _ in range(3):
    puzzle += "".join(list(input().split()))

puzzle = puzzle.replace("0", "9")


def bfs():
    q = deque()
    v = {}

    q.append(puzzle)
    v[puzzle] = 0

    while q:
        c = q.popleft()
        if c == "123456789":
            return v[c]

        pos = c.find("9")
        ci, cj = pos // 3, pos % 3

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < 3 and 0 <= nj < 3:
                npos = ni * 3 + nj
                np = list(c)
                np[npos], np[pos] = np[pos], np[npos]
                np = "".join(np)

                if np not in v:
                    q.append(np)
                    v[np] = v[c] + 1

    return -1


ans = bfs()
print(ans)