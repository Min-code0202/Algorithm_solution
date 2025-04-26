T = input()
N = int(input())
major_lst = [list(map(str, input().split())) for _ in range(N)]

ans = float('inf')
visit = [0] * N

def search(depth, major, total, i):
    global ans
    if depth == len(T):
        ans = min(ans, total)
        return
    
    t = T[depth]
    
    cost = int(major[0])
    title = major[1]
    
    if t in title:
        if visit[i] == 0:
            total += cost
        for j in range(N):
            visit[i] = 1
            search(depth + 1, major_lst[j], total, j)
            visit[i] = 0



for i in range(N):
    search(0, major_lst[i], 0, i)

print(ans if ans != float('inf') else -1)