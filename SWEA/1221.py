T = int(input())
for t in range(1, T + 1):
    _, N = input().split()
    N = int(N)
    dct = {0:'ZRO', 1:'ONE', 2:'TWO', 3:'THR', 4:'FOR', 5:'FIV', 6:'SIX', 7:'SVN', 8:'EGT', 9:'NIN'}
    st = list(map(str, input().split()))

    ans = []
    for i in range(10):
        for j in range(N):
            if dct[i] == st[j]:
                ans.append(st[j])

    print(f'#{t}')
    print(*ans)