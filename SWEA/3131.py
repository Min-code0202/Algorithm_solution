import math

N = 10**6
array = [True] * (N + 1)
array[0] = array[1] = False  # 0과 1은 소수 아님

# 에라토스테네스의 체
for i in range(2, int(math.sqrt(N)) + 1):
    if array[i]:
        for j in range(i * i, N + 1, i):
            array[j] = False

# 모든 소수 출력
for i in range(2, N + 1):
    if array[i]:
        print(i, end=' ')