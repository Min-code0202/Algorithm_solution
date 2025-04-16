N, M = map(int, input().split())

def search(c_num, depth):
    if depth == M:
        ans[depth] = c_num
        print(' '.join(map(str, ans[1:])))
        return
    
    ans[depth] = c_num
    for i in range(1, N + 1):
        if i >= c_num:
            search(i, depth + 1)


ans = [0] * (M + 1)
search(0, 0)