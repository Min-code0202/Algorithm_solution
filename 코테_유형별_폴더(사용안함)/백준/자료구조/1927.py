N = int(input())

heap = []
for _ in range(N):
    x = int(input())
    
    if x == 0:
        if not heap:
            print(0)
        else:
            print(heap.pop(0))
    else:
        heap.append(x)
        heap.sort()
