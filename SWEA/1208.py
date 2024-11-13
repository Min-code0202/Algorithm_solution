for t in range(1, 11):
    dump = int(input())
    box = list(map(int, input().split()))
    
    for d in range(dump): 
        max_box = max(box)
        max_idx = box.index(max_box)
        min_box = min(box)
        min_idx = box.index(min_box)
        
        box[max_idx] -= 1
        box[min_idx] += 1
       
    ans = max(box) - min(box) 
    print(f'#{t} {ans}')