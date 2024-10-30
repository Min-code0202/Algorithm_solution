w, h = map(int, input().split())
w_list = [0, w]
h_list = [0, h]

N = int(input())
for _ in range(N):
    a, b = map(int, input().split())
    if a == 0:
        h_list.append(b)
    else:
        w_list.append(b)

w_list.sort()
h_list.sort()

result = 0
for i in range(len(w_list) - 1):
    for j in range(len(h_list) - 1):
        area = (w_list[i+1] - w_list[i]) * (h_list[j + 1] - h_list[j])
        result = max(result, area)
        
print(result)