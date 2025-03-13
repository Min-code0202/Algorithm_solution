N, M = map(int, input().split())
height = list(map(int, input().split()))

def solution():
    high = max(height)
    low = min(height)

    branch = sum(height) - low*N # 가장 낲은 높이의 나무보다 위에 있는 나무 칸의 개수
    if branch > M:
        while True:
            sum_value = 0
            for i in range(N):
                if height[i] > high:
                   diff = height[i] - high
                   sum_value += diff
            
            if sum_value >= M:
                return high
            high -= 1
    elif branch == M:
        return low
    else:
        while True:
            branch += N
            cnt += 1
            if branch > M:
                return low - cnt

result = solution()

print(result)