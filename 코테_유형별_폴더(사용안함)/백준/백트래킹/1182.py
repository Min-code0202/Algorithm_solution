N, S = map(int, input().split())
num_lst = list(map(int, input().split()))

cnt = 0

def dfs(depth, current_sum):
    global cnt
    if depth >= N:
        return
    current_sum += num_lst[depth]
    if current_sum == S:
        cnt += 1
    # 포함하는 경우
    dfs(depth + 1, current_sum)
    # 포함하지 않는 경우
    dfs(depth + 1, current_sum - num_lst[depth])

dfs(0, 0)
print(cnt)