N, M = map(int, input().split())
num_lst = sorted(list(map(int, input().split())))
ans = [0] * (M + 1)

def search(c_num, depth):
    if depth == M:
        ans[depth] = c_num
        print(' '.join(map(str, ans[1:])))
        return
    
    ans[depth] = c_num
    pre = -1
    for i in range(len(num_lst)):
        if pre != num_lst[i] and num_lst[i] >= c_num:
            pre = num_lst[i]
            search(num_lst[i], depth + 1)


search(0, 0)