T = int(input())

def inorder(n):
    global cnt
    if n <= N:
        inorder(n*2)
        tree[n] = cnt
        cnt += 1
        inorder(n*2 + 1)


for t in range(1, T + 1):
    N = int(input())
    tree = [0] * (N + 1)
    
    cnt = 1
    inorder(cnt)
    print(f'#{t} {tree[1]} {tree[N//2]}')