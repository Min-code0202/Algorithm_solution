N = int(input())
area = [0] * 1001

for _ in range(N):
    index, height = map(int, input().split())
    area[index] = height

max_index = area.index(max(area))

prev_max_value = 0
for i in range(0, max_index):
    prev_max_value = max(prev_max_value, area[i])
    area[i] = prev_max_value
    
prev_max_value = 0
for i in range(len(area) - 1, max_index, -1):
    prev_max_value = max(prev_max_value, area[i])
    area[i] = prev_max_value
    
print(sum(area)) 