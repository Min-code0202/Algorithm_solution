T = int(input())

def solve(depth, lst):
    global ans
    if depth == N:
        alpha = [0] * 26
        for word in lst:
            for ch in word:
                alpha[ord(ch) - ord('a')] += 1
        if all(alpha[i] > 0 for i in range(26)):
            ans += 1
        return

    solve(depth + 1, lst + [arr[depth]])
    solve(depth + 1, lst)

for t in range(1, T + 1):
    N = int(input())
    arr = [input().strip() for _ in range(N)]

    ans = 0
    solve(0, [])
    print(f'#{t} {ans}')
