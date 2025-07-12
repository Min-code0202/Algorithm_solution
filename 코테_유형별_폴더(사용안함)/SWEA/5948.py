T = int(input())

def solve(depth, c_num, sm):
    if depth == 3:
        ans.append(sm)
        return
    
    for i in range(c_num + 1, 7):
        solve(depth + 1, i, sm + n[i])

for t in range(1, T + 1):
    n = list(map(int, input().split()))

    ans = []
    solve(0, -1, 0)

    ans = sorted(set(ans))
    print(f'#{t} {ans[-5]}')