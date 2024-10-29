N, M = map(int, input().split())
card = list(map(int, input().split()))

from itertools import combinations

result = 0

for three in combinations(card, 3):
    if sum(three) > M:
        continue
    else:
        result = max(result, sum(three))

print(result)