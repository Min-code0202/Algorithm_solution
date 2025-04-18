T = int(input())
for t in range(1, T + 1):
    N = int(input())
    A, B = [], []
    for _ in range(N):
        a, b = map(int, input().split())
        A.append(a)
        B.append(b)
    
    P = int(input())
    C = list(int(input()) for _ in range(P))

    bus = [0] * 5001
    for i in range(N):
        for j in range(A[i], B[i] + 1):
            bus[j] += 1

    ans = []
    for c in C:
        ans.append(bus[c])

    result = ' '.join(map(str, ans))
    print(f'#{t} {result}')