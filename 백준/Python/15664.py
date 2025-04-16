N, M = map(int, input().split())
num_lst = sorted(list(map(int, input().split())))


def search(c_num, depth):
    if depth == M:
        ans[depth] = c_num
        print(' '.join(map(str, ans[1:])))
        return
    
    pre = -1
    ans[depth] = c_num
    for i in range(0, len(num_lst)):
        if pre != num_lst[i] and visit[i] == 0 and num_lst[i] >= c_num:
            pre = num_lst[i]
            visit[i] = 1
            search(num_lst[i], depth + 1) 
            visit[i] = 0


ans = [0] * (M + 1)
visit = [0] * N
search(0, 0)