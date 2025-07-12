N, M = map(int, input().split())
height = list(map(int, input().split()))

cut_height = max(height)

sum_value = 0
while True:
    for i in range(N):
        diff = height[i] - cut_height
        sum_value += diff if diff > 0 else 0

    if sum_value >= M:
        break
    
    cut_height -= 1
    sum_value = 0

print(cut_height)