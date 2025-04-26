N, M = map(int, input().split())
num_lst = list(map(int, input().split()))
num_lst.sort()


def search(c_num, depth):
    if depth == M:
        seq[depth] = c_num
        ans.append(' '.join(map(str, seq[1:])))
        return
    
    seq[depth] = c_num
    for i in range(0, len(num_lst)):
        if visit[i] == 0:
            visit[i] = 1
            search(num_lst[i], depth + 1)
            visit[i] = 0

ans = []
seq = [0] * (M + 1)
visit = [0] * (N + 1)
search(0, 0)

seen = set()
unique_ans = []
for sub in ans:
    t = tuple(sub)
    if t not in seen:
        seen.add(t)
        unique_ans.append(sub)

print('\n'.join(map(str, unique_ans)))