T = int(input())
for t in range(1, T + 1):
    N = int(input())
    arr = [int(input()) for _ in range(N)]

    ans = 0
    ori = sum(arr)//N
    for i in range(N):
        if arr[i] > ori:
            ans += arr[i] - ori
    
    print(f'#{t} {ans}')