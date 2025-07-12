T = int(input())
for t in range(1, T + 1):
    score = list(map(int, input().split()))

    for i in range(5):
        score[i] = 40 if score[i] < 40 else score[i]

    ans = sum(score)//5
    print(f'#{t} {ans}')