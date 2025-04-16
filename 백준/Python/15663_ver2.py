N, M = map(int, input().split())
num_lst = list(map(int, input().split()))
num_lst.sort()


def search(c_num, depth):
    if depth == M:
        ans[depth] = c_num
        print(' '.join(map(str, ans[1:])))
        return
    
    pre = -1
    ans[depth] = c_num
    for i in range(0, len(num_lst)):
        if visit[i] == 0 and pre != num_lst[i]:
            pre = num_lst[i]
            visit[i] = 1
            search(num_lst[i], depth + 1)
            visit[i] = 0


ans = [0] * (M + 1)
visit = [0] * (N + 1)
search(0, 0)