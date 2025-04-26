N, M = map(int, input().split())
num_lst = list(map(int, input().split()))
num_lst.sort()

def search(c_num, depth):
    if depth == M:
        ans[depth] = c_num
        print(' '.join(map(str, ans[1:])))
        return
    
    ans[depth] = c_num
    for n in num_lst:
        if n > c_num:
            search(n, depth + 1)


ans = [0] * (M + 1)
search(0, 0)