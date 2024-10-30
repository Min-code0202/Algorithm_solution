L = int(input())
N = int(input())
cake = [1]*(L + 1)

max_cake_index = max_cake_value = max_real_index = max_real_value = 0
for i in range(1, N + 1):
    start, end = map(int, input().split())
    if max_cake_value < end - start + 1:
        max_cake_value = end - start + 1
        max_cake_index = i
    cnt = 0
    for j in range(start, end + 1):
        if cake[j] == 1:
            cake[j] = 0
            cnt += 1
        
    if cnt > max_real_value:
        max_real_value = cnt
        max_real_index = i 
        
print(max_cake_index)
print(max_real_index)