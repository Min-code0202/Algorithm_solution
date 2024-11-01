N, K = map(int, input().split())
temper = list(map(int, input().split()))

# 0 ~ K 까지 처음 합
sum = 0
for i in range(K):
    sum += temper[i]

max_sum = sum
for i in range(1, len(temper) - K + 1):
    sum = sum - temper[i - 1] + temper[i + K - 1] 
    max_sum = max(max_sum, sum)
     
print(max_sum)